package net.crsimple.nyahlib.api.config;

/**
 * The marker interface for a configuration object
 * @since 1.0a
 */
public interface Configuration {
    /**
     * Override this method to validate config values when the config is loaded.
     * if the config is not valid, throw {@link ConfigLoadingException} with message.
     * <pre>{@code Config modid:config.json is not valid: error message}</pre>
     *
     * @throws ConfigLoadingException if config is not valid
     */
    default void checkConfig() throws ConfigLoadingException {
    }

    /**
     * @return {@code true} if the config should be force-loaded despite a {@link ConfigLoadingException};<br>
     *         {@code false} if the default config should be loaded instead.
     * @see #checkConfig()
     */
    default boolean shouldLoadingInCaseException() {
        return false;
    }
}
