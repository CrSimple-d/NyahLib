package net.crsimple.nyahlib.api.config;

public class InvalidConfigException extends Exception {
    public InvalidConfigException(String message) {
        super(message);
    }
    public InvalidConfigException(String message, Exception e) {
        super(message,e);
    }
}
