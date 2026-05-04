package net.crsimple.nyahlib.api.config;

/**
 * @since 1.0a
 */
public interface ConfigFactory<T extends Configuration> {
    T create();
}
