package com.clerk.backend_api.helpers.security;

/**
 * A functional interface similar to Supplier but allows checked exceptions to be thrown.
 *
 * @param <T> the type of results supplied by this supplier
 * @param <E> the type of exception that may be thrown
 */
@FunctionalInterface
public interface CheckedSupplier<T, E extends Exception> {
    /**
     * Gets a result, potentially throwing a checked exception.
     *
     * @return a result
     * @throws E if unable to supply a result
     */
    T get() throws E;
}