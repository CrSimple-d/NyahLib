package net.crsimple.nyahlib.example.config;

import net.crsimple.nyahlib.api.config.ConfigLoadingException;
import net.crsimple.nyahlib.api.config.Configuration;

import java.util.Locale;

public class DemoMutableConfig implements Configuration {
    public String hello = "Hello World";

    @Override
    public void checkConfig() throws ConfigLoadingException {
        if (!hello.toLowerCase(Locale.ROOT).startsWith("hello")) {
            throw new ConfigLoadingException("hello field must starts with 'hello'");
        }
    }

    @Override
    public boolean shouldLoadingInCaseException() {
        return true;
    }
}
