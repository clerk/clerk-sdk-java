package com.clerk.backend_api.hooks;

import com.clerk.backend_api.hooks.telemetry.TelemetryAfterErrorHook;
import com.clerk.backend_api.hooks.telemetry.TelemetryAfterSuccessHook;
import com.clerk.backend_api.hooks.telemetry.TelemetryBeforeRequestHook;
import com.clerk.backend_api.utils.Hook;
import com.clerk.backend_api.utils.Hooks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SDKHooksTest {

    private TestableHooks hooks;

    @BeforeEach
    void setUp() {
        hooks = new TestableHooks();
    }

    @Test
    void testInitialize_RegistersClerkBeforeRequestHook() {
        SDKHooks.initialize(hooks);

        boolean hasClerkBeforeRequestHook = hooks.beforeRequestHooks.stream()
                .anyMatch(hook -> hook instanceof ClerkBeforeRequestHook);
        assertTrue(hasClerkBeforeRequestHook, "Should register ClerkBeforeRequestHook");
    }

    @Test
    void testConfigureTelemetry_WithTelemetryEnabled_RegistersAllTelemetryHooks() {
        SDKHooks.configureTelemetry(hooks, null, null);

        boolean hasBeforeRequestTelemetry = hooks.beforeRequestHooks.stream()
                .anyMatch(hook -> hook instanceof TelemetryBeforeRequestHook);
        boolean hasAfterSuccessTelemetry = hooks.afterSuccessHooks.stream()
                .anyMatch(hook -> hook instanceof TelemetryAfterSuccessHook);
        boolean hasAfterErrorTelemetry = hooks.afterErrorHooks.stream()
                .anyMatch(hook -> hook instanceof TelemetryAfterErrorHook);

        assertTrue(hasBeforeRequestTelemetry, "Should register TelemetryBeforeRequestHook");
        assertTrue(hasAfterSuccessTelemetry, "Should register TelemetryAfterSuccessHook");
        assertTrue(hasAfterErrorTelemetry, "Should register TelemetryAfterErrorHook");
    }

    @Test
    void testConfigureTelemetry_WithTelemetryDisabled_DoesNotRegisterTelemetryHooks() {
        SDKHooks.configureTelemetry(hooks, "1", null);

        assertTrue(hooks.beforeRequestHooks.isEmpty(), "Should not register any before request telemetry hooks");
        assertTrue(hooks.afterSuccessHooks.isEmpty(), "Should not register any after success hooks");
        assertTrue(hooks.afterErrorHooks.isEmpty(), "Should not register any after error hooks");
    }

    @Test
    void testConfigureTelemetry_WithTelemetryDebugEnabled_RegistersDebugCollector() throws Exception {
        SDKHooks.configureTelemetry(hooks, null, "1");

        {
            TelemetryBeforeRequestHook telBefore = (TelemetryBeforeRequestHook) hooks.beforeRequestHooks.stream()
                    .filter(hook -> hook instanceof TelemetryBeforeRequestHook)
                    .findFirst()
                    .orElseThrow(() -> new AssertionError("TelemetryBeforeRequestHook not found"));

            assertEquals(2, telBefore.collectors.size(), "Should have 2 collectors when debug is enabled");
        }

        {
            TelemetryAfterSuccessHook telAfter = (TelemetryAfterSuccessHook) hooks.afterSuccessHooks.stream()
                    .filter(hook -> hook instanceof TelemetryAfterSuccessHook)
                    .findFirst()
                    .orElseThrow(() -> new AssertionError("TelemetryAfterSuccessHook not found"));

            assertEquals(2, telAfter.collectors.size(), "Should have 2 collectors when debug is enabled");
        }

        {
            TelemetryAfterErrorHook telError = (TelemetryAfterErrorHook) hooks.afterErrorHooks.stream()
                    .filter(hook -> hook instanceof TelemetryAfterErrorHook)
                    .findFirst()
                    .orElseThrow(() -> new AssertionError("TelemetryAfterErrorHook not found"));

            assertEquals(2, telError.collectors.size(), "Should have 2 collectors when debug is enabled");
        }
    }

    /**
     * A testable version of Hooks that exposes registered hooks for assertion
     */
    private static class TestableHooks extends Hooks {
        final List<Object> beforeRequestHooks = new java.util.ArrayList<>();
        final List<Object> afterSuccessHooks = new java.util.ArrayList<>();
        final List<Object> afterErrorHooks = new java.util.ArrayList<>();

        @Override
        public Hooks registerBeforeRequest(Hook.BeforeRequest hook) {
            beforeRequestHooks.add(hook);
            return this;
        }

        @Override
        public Hooks registerAfterSuccess(Hook.AfterSuccess hook) {
            afterSuccessHooks.add(hook);
            return this;
        }

        @Override
        public Hooks registerAfterError(Hook.AfterError hook) {
            afterErrorHooks.add(hook);
            return this;
        }
    }
}