package net.crsimple.nyahlib;

import net.crsimple.nyahlib.example.config.DemoConfigurations;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LibMain implements ModInitializer {
    public static String MOD_ID = "nyahlib";
    public static Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Nyah :3");
        DemoConfigurations.init();
    }
}
