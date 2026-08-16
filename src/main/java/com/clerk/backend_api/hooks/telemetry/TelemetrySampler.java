package com.clerk.backend_api.hooks.telemetry;

import com.clerk.backend_api.utils.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Random;
import java.util.function.BiPredicate;

public interface TelemetrySampler extends BiPredicate<PreparedEvent, TelemetryEvent> {

    class RandomSampler implements TelemetrySampler {
        private final Random random;

        public RandomSampler(Random random) {
            this.random = random;
        }

        @Override
        public boolean test(PreparedEvent preparedEvent, TelemetryEvent event) {
            return random.nextDouble(0, 1.0) < event.samplingRate;
        }

        public static RandomSampler standard() {
            return new RandomSampler(new Random(1L));
        }
    }

    class DeduplicatingSampler implements TelemetrySampler {
        private final HashMap<String, LocalDateTime> cache;
        private final Duration window;
        private final Clock clock;

        public DeduplicatingSampler(Duration window, Clock clock) {
            this.window = window;
            this.clock = clock;
            this.cache = new HashMap<>(16);
        }

        @Override
        public boolean test(PreparedEvent preparedEvent, TelemetryEvent event) {
            try {
                String key = JSON.getMapper().writeValueAsString(preparedEvent.sanitize());
                LocalDateTime now = LocalDateTime.now(clock);
                LocalDateTime lastSampled = cache.get(key);

                if (lastSampled == null || !Duration.between(lastSampled, now).minus(window).isNegative()) {
                    cache.put(key, now);
                    return true;
                }
            } catch (JsonProcessingException ignored) {
            }
            return false;
        }

        public static TelemetrySampler standard() {
            return new DeduplicatingSampler(Duration.ofDays(1), Clock.systemUTC());
        }

    }

}
