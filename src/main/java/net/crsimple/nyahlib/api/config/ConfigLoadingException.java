package net.crsimple.nyahlib.api.config;

public class ConfigLoadingException extends Exception {
    public ConfigLoadingException(String message) {
        super(message);
    }
    public ConfigLoadingException(String message,Exception e) {
        super(message,e);
    }
}
