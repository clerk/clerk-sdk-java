package com.clerk.backend_api.helpers.security;

import java.util.HashMap;
import java.util.Map;

/**
 * In-memory cache with expiration.
 */
public class Cache {
    private final Map<String, CacheEntry> cache = new HashMap<>();
    private final int expirationTimeSeconds = 300; // 5 minutes

    private static class CacheEntry {
        private final String value;
        private final long expiration;

        public CacheEntry(String value, long expiration) {
            this.value = value;
            this.expiration = expiration;
        }

        public String getValue() {
            return value;
        }

        public long getExpiration() {
            return expiration;
        }
    }

    /**
     * Stores a value in the cache with an expiration time.
     *
     * @param key   The cache key.
     * @param value The value to cache.
     */
    public void set(String key, String value) {
        if (key == null) {
            return;
        }

        long expiration = System.currentTimeMillis() / 1000 + expirationTimeSeconds;
        cache.put(key, new CacheEntry(value, expiration));
    }

    /**
     * Retrieves a value from the cache if it exists and has not expired.
     *
     * @param key The cache key.
     * @return The cached value, or null if not found or expired.
     */
    public String get(String key) {
        if (key == null) {
            return null;
        }

        CacheEntry entry = cache.get(key);
        if (entry != null) {
            long currentTime = System.currentTimeMillis() / 1000;
            if (currentTime < entry.getExpiration()) {
                return entry.getValue();
            }

            // Expired, remove from cache
            cache.remove(key);
        }

        return null;
    }
}
