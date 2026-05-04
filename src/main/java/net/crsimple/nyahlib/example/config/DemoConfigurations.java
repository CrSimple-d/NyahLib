package net.crsimple.nyahlib.example.config;

import net.crsimple.nyahlib.LibMain;
import net.crsimple.nyahlib.api.config.ConfigInitializer;
import net.crsimple.nyahlib.api.config.ConfigInstance;
import net.minecraft.util.Identifier;

public class DemoConfigurations {
    public static ConfigInstance<DemoImmutableConfig> IMMUTABLE_CONFIG = ConfigInitializer.registerImmutable(Identifier.of(LibMain.MOD_ID,"nyah/demo/immutable.json"),DemoImmutableConfig::new);
    public static ConfigInstance<DemoMutableConfig> MUTABLE_CONFIG = ConfigInitializer.registerMutable(Identifier.of(LibMain.MOD_ID,"nyah/demo/mutable.json"),DemoMutableConfig::new);

    public static void init() {
    }
}
