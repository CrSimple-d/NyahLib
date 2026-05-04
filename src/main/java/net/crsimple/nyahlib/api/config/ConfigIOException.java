package net.crsimple.nyahlib.api.config;

/**
 * Unchecked exception, throws when occurred {@link java.io.IOException} during file reading / writing or file is bot valid
 *
 * @since 1.0a
 */
public class ConfigIOException extends RuntimeException {
    public ConfigIOException(String message) {
        super(message);
    }
    public ConfigIOException(String message, Throwable cause) {
        super(message, cause);
    }
}
