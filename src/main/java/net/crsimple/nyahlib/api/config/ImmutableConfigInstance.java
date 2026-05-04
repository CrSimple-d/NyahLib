package net.crsimple.nyahlib.api.config;

import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

/**
 * A tool for managing your immutable configuration, making it easy to work with
 * @since 1.0a
 */
public class ImmutableConfigInstance<T extends Configuration> extends AbstractConfigInstance<T> {
    public ImmutableConfigInstance(@NotNull String path, Identifier id, ConfigFactory<T> factory) {
        super(path, id, factory);
    }

    /**
     * Saves a config {@code t} at the {@code path} with current {@code localManager}.
     * No reload, only save
     *
     * @param t config instance of {@code <T>} type
     * @return saved config
     * @throws ConfigIOException if {@link java.io.IOException} occurred or {@code path} is not valid
     */
    public T save(T t) {
        getLocalManagerOrDefault().save(path,t);
        return t;
    }

    @Override
    public boolean isMutable() {
        return false;
    }
}
