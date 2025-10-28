package com.clerk.backend_api.helpers.security;

import com.clerk.backend_api.helpers.security.models.TokenVerificationException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * In-memory cache with expiration.
 */
public class Cache {
    private final Map<String, CacheEntry> cache = new ConcurrentHashMap<>();
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

    /**
     * Retrieves a value from the cache if it exists and has not expired.
     * If the value is not present in the cache, computes it using the provided supplier,
     * stores it in the cache, and returns it.
     *
     * @param key      The cache key.
     * @param supplier The supplier to compute the value if not present in cache.
     * @return The cached or computed value.
     * @throws TokenVerificationException if the supplier throws an exception.
     */
    public String getOrCompute(String key, CheckedSupplier<String, TokenVerificationException> supplier) throws TokenVerificationException {
        String cachedValue = get(key);
        if (cachedValue != null) {
            return cachedValue;
        }

        String computedValue = supplier.get();
        set(key, computedValue);
        return computedValue;
    }
}
