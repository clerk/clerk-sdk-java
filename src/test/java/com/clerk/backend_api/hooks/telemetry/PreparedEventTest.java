package com.clerk.backend_api.hooks.telemetry;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class PreparedEventTest {

    @Test
    void testSanitize_ContainsAllFields() {
        // Arrange
        String event = "test-event";
        String it = "test-it";
        String sdk = "java";
        String sdkv = "1.0.0";
        String sk = "sk_test_123";
        Map<String, String> payload = Map.of("key1", "value1", "key2", "value2");

        PreparedEvent preparedEvent = new PreparedEvent(event, it, sdk, sdkv, sk, payload);

        // Act
        TreeMap<String, String> sanitized = preparedEvent.sanitize();

        // Assert
        assertEquals(event, sanitized.get("event"), "Event should be included");
        assertEquals(it, sanitized.get("it"), "It should be included");
        assertEquals(sdk, sanitized.get("sdk"), "SDK should be included");
        assertEquals(sdkv, sanitized.get("sdkv"), "SDKV should be included");
        assertEquals("value1", sanitized.get("key1"), "Payload key1 should be included");
        assertEquals("value2", sanitized.get("key2"), "Payload key2 should be included");
    }

    @Test
    void testSanitize_DoesNotIncludeSk() {
        // Arrange
        PreparedEvent preparedEvent = new PreparedEvent(
                "test-event",
                "test-it",
                "java",
                "1.0.0",
                "sk_test_123",
                Map.of()
        );

        // Act
        TreeMap<String, String> sanitized = preparedEvent.sanitize();

        // Assert
        assertFalse(sanitized.containsKey("sk"), "SK should not be included in sanitized output");
    }

    @Test
    void testSanitize_PayloadOverridesDefaultFields() {
        // This is a negative test
        // It's not that we want this behaviour so much as we want to document it
        // Arrange
        Map<String, String> payload = new HashMap<>();
        payload.put("event", "overridden-event");
        payload.put("sdk", "overridden-sdk");

        PreparedEvent preparedEvent = new PreparedEvent(
                "original-event",
                "test-it",
                "original-sdk",
                "1.0.0",
                "sk_test_123",
                payload
        );

        // Act
        TreeMap<String, String> sanitized = preparedEvent.sanitize();

        // Assert
        assertEquals("overridden-event", sanitized.get("event"), "Payload should override default fields");
        assertEquals("overridden-sdk", sanitized.get("sdk"), "Payload should override default fields");
    }

    @Test
    void testSanitize_HandlesEmptyPayload() {
        // Arrange
        PreparedEvent preparedEvent = new PreparedEvent(
                "test-event",
                "test-it",
                "java",
                "1.0.0",
                "sk_test_123",
                Map.of()
        );

        // Act
        TreeMap<String, String> sanitized = preparedEvent.sanitize();

        // Assert
        assertEquals(4, sanitized.size(), "Should have 4 entries with empty payload");
        assertEquals("test-event", sanitized.get("event"));
        assertEquals("test-it", sanitized.get("it"));
        assertEquals("java", sanitized.get("sdk"));
        assertEquals("1.0.0", sanitized.get("sdkv"));
    }

    @Test
    void testSanitize_SortsKeys() {
        // Arrange
        Map<String, String> payload = new HashMap<>();
        payload.put("z-key", "z-value");
        payload.put("a-key", "a-value");
        payload.put("m-key", "m-value");

        PreparedEvent preparedEvent = new PreparedEvent(
                "test-event",
                "test-it",
                "java",
                "1.0.0",
                "sk_test_123",
                payload
        );

        // Act
        TreeMap<String, String> sanitized = preparedEvent.sanitize();

        // Assert
        // TreeMap sorts keys alphabetically
        String[] expectedOrder = {"a-key", "event", "it", "m-key", "sdk", "sdkv", "z-key"};
        String[] actualOrder = sanitized.keySet().toArray(new String[0]);

        assertArrayEquals(expectedOrder, actualOrder, "Keys should be in alphabetical order");
    }
}
