package net.crsimple.nyahlib.example.config;

import com.google.gson.annotations.SerializedName;
import net.crsimple.nyahlib.api.config.InvalidConfigException;
import net.crsimple.nyahlib.api.config.Configuration;
import net.crsimple.nyahlib.util.ConfigHelper;

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
    public void checkConfig() throws InvalidConfigException {
        ConfigHelper.limit("some_int",someInt,0,3000);
    }
}
