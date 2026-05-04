package net.crsimple.nyahlib.example.config;

import com.google.gson.annotations.SerializedName;
import net.crsimple.nyahlib.api.config.ConfigLoadingException;
import net.crsimple.nyahlib.api.config.Configuration;

public class DemoImmutableConfig implements Configuration {
    @SerializedName("some_int")
    public final int someInt;

    public DemoImmutableConfig() {
        this.someInt = 0;
    }

    public DemoImmutableConfig(int someInt) {
        this.someInt = someInt;
    }

    @Override
    public void checkConfig() throws ConfigLoadingException {
        if (someInt < 0 || someInt > 2000) {
            throw new ConfigLoadingException("some_int must be greater than 0 and less than 2000");
        }
    }
}
