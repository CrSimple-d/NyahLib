package net.crsimple.nyahlib.api.config;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

/**
 * Default implementation of {@link ConfigInstance}
 * @since 1.0a
 */
public abstract class ConfigInstanceImpl<T extends Configuration> implements ConfigInstance<T> {
    /**
     * The manager that will use for load or save config
     */
    protected @Nullable ConfigIOManager localManager;
    /**
     * Path to configuration relative the path of {@link ConfigIOManager#config} for {@code localManager}
     */
    protected @NotNull String path;
    protected T config;

    protected ConfigInstanceImpl(T config, @NotNull String path) {
        this.path = path;
        this.config = config;
    }

    /**
     * @return the config deserialized with {@link ConfigIOManager} from {@link #getLocalManagerOrDefault()} and {@code path}, saves if config doesn't exist
     * @see ConfigInstance#load()
     */
    @Override
    public T load() {
        return getLocalManagerOrDefault().loadWithSave(path,config);
    }

    /**
     * @return {@link ConfigIOManager#INSTANCE} if {@code localManager} is null or {@code localManager} if not null
     */
    protected ConfigIOManager getLocalManagerOrDefault() {
        return localManager != null? localManager : ConfigIOManager.INSTANCE;
    }

    @Override
    public T get() {
        return config;
    }

    /**
     * @return current {@code localManager}
     */
    public Optional<ConfigIOManager> getLocalManager() {
        return Optional.ofNullable(localManager);
    }

    /**
     * {@code localManager} is {@link ConfigIOManager} instance that will use for load or save config.
     * If {@code localManager} null then will use {@link ConfigIOManager#INSTANCE} as default
     */
    public void setLocalManager(@Nullable ConfigIOManager localManager) {
        this.localManager = localManager;
    }

    public @NotNull String getPath() {
        return path;
    }

    /**
     * Sets path to configuration relative the path of {@link ConfigIOManager#config} for {@code localManager}
     */
    public void setPath(@NotNull String path) {
        this.path = path;
    }
}
