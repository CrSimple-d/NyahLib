package net.crsimple.nyahlib.api.config;

/**
 * A tool for managing your configuration, making it easy to work with
 * @param <T> configuration type
 * @since 1.0a
 */
public interface ConfigInstance<T extends Configuration> {

    /**
     * Reloads config from file
     *
     * @return reloaded instance of {@code <T>} type config
     * @throws ConfigIOException if config isn't valid
     */
    T load();

    /**
     * @return config instance of {@code <T>} type
     */
    T get();

    /**
     * @return {@code true} if config registered as mutable or {@code false} if config registered as immutable
     * @see MutableConfigInstance
     * @see ImmutableConfigInstance
     */
    boolean isMutable();
}
