package net.crsimple.nyahlib.api.config;

import net.crsimple.nyahlib.LibMain;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

/**
 * @since 1.0a
 */
public abstract class AbstractConfigInstance<T extends Configuration> extends ConfigInstanceImpl<T> {
    protected final Identifier id;
    protected final ConfigFactory<T> factory;

    protected AbstractConfigInstance(@NotNull String path, Identifier id, ConfigFactory<T> factory) {
        super(factory.create(), path);
        this.id = id;
        this.factory = factory;
        init();
    }

    /**
     * {@link ConfigInstance} init method.<br>
     * Loads config if exists
     */
    public void init() {
        load();
    }

    /**
     * @return construction identifier from {@link ConfigInitializer}
     */
    public Identifier getId() {
        return id;
    }

    /**
     * Reloads config from file and validating it with {@link Configuration#checkConfig()}
     * @see ConfigInstanceImpl#load()
     */
    @Override
    public T load() {
        T instance = super.load();
        try {
            instance.checkConfig();
        } catch (InvalidConfigException e) {
            LibMain.LOGGER.error("Config {} is not valid: {}", getId(), e.getMessage());
            if (!instance.shouldLoadingInCaseException()) {
                LibMain.LOGGER.warn("Using default configuration for {}", getId());
                instance = factory.create();
            } else {
                LibMain.LOGGER.warn("Continue loading for {}", getId());
            }
        }
        return config = instance;
    }
}
