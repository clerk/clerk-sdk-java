package com.clerk.backend_api.hooks.telemetry;

import com.clerk.backend_api.utils.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface TelemetryCollector {

    void collect(TelemetryEvent event);

    static TelemetryCollector live() {
        return new LiveCollector(
            List.of(TelemetrySampler.RandomSampler.standard(), TelemetrySampler.DeduplicatingSampler.standard()),
            Executors.newFixedThreadPool(2, r -> {
                Thread t = new Thread(r);
                t.setDaemon(true);
                t.setName("telemetry-collector");
                return t;
            }));
    }

    abstract class BaseCollector implements TelemetryCollector {

        private final String sdkv;
        private final String sdk;

        public BaseCollector() {
            Optional<SdkInfo> sdkInfo = SdkInfo.loadFromResources();
            sdkv = sdkInfo.map(x -> x.version).orElse("unknown");
            sdk = sdkInfo.map(x -> x.groupId + ":" + x.name).orElse("java:unknown");
        }

        @Override
        public final void collect(TelemetryEvent event) {
            if (event.it.equals("development")) {
                collectInternal(event);
            }
        }

        protected String serializeToJson(PreparedEvent preparedEvent) throws JsonProcessingException {
            return JSON.getMapper().writeValueAsString(preparedEvent);
        }

        protected PreparedEvent prepareEvent(TelemetryEvent event) {
            // We use a TreeMap to ensure the order of the fields in the JSON
            // Here just for convenience
            return new PreparedEvent(
                    event.event,
                    event.it,
                    sdk,
                    sdkv,
                    event.sk,
                    new TreeMap<>(event.payload)
            );
        }

        protected abstract void collectInternal(TelemetryEvent event);

    }

    class DebugCollector extends BaseCollector {
        @Override
        protected void collectInternal(TelemetryEvent event) {
            try {
                System.err.println(serializeToJson(prepareEvent(event)));
            } catch (JsonProcessingException e) {
                System.err.println("Failed to serialize event: " + e.getMessage());
            }
        }

    }

    class LiveCollector extends BaseCollector {
        private static final String ENDPOINT = "http://localhost:3000/";
        private final ExecutorService svc;
        private final List<TelemetrySampler> samplers;

        private static final Logger logger = Logger.getLogger(LiveCollector.class.getName());

        public LiveCollector(List<TelemetrySampler> samplers, ExecutorService svc) {
            super();
            this.svc = svc;
            this.samplers = samplers;
        }

        @Override
        protected void collectInternal(TelemetryEvent event) {
            PreparedEvent preparedEvent = prepareEvent(event);
            for (TelemetrySampler sampler : samplers) {
                if (!sampler.test(preparedEvent, event)) {
                    return;
                }
            }

            svc.submit(() -> sendEvent(event));
        }

        public void sendEvent(TelemetryEvent event) {
            try {
                URL url = new URL(ENDPOINT);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                try { // Try-with-resources doesn't work here because a HttpURLConnection isn't AutoCloseable
                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Content-Type", "application/json");
                    connection.setRequestProperty("Connection", "close");
                    connection.setDoOutput(true);

                    String eventJson = serializeToJson(prepareEvent(event));
                    try (OutputStream os = connection.getOutputStream()) {
                        IOUtils.write(eventJson, os, StandardCharsets.UTF_8);
                    }

                    // Strictly we don't have to read the response, but if we don't and the server is trying to respond
                    // it's going to keep getting connection resets. So we read the response and log it.
                    int responseCode = connection.getResponseCode();
                    if (responseCode != HttpURLConnection.HTTP_OK && responseCode != HttpURLConnection.HTTP_CREATED) {
                        InputStream errorStream = connection.getErrorStream();
                        String errorMsg = errorStream != null ? IOUtils.toString(errorStream, StandardCharsets.UTF_8) : "";
                        logger.log(Level.WARNING, "Failed to send telemetry event. Response code: " + responseCode + ", error: " + errorMsg);
                    } else {
                        InputStream responseStream = connection.getInputStream();
                        String response = responseStream != null ? IOUtils.toString(responseStream, StandardCharsets.UTF_8) : "";
                        logger.log(Level.FINE, "Telemetry event sent successfully. Response: " + response);
                    }

                } finally {
                    connection.disconnect();
                }
            } catch (Exception e) {
                // Log the exception but don't let it propagate
                System.err.println("Error sending telemetry event: " + e.getMessage());
            }
        }
    }

}
