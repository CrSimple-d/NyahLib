package net.crsimple.nyahlib.api.config;

import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

/**
 * A tool for managing your mutable configuration, making it easy to work with
 * @since 1.0a
 */
public class MutableConfigInstance<T extends Configuration> extends AbstractConfigInstance<T> {
    public MutableConfigInstance(@NotNull String path, Identifier id, ConfigFactory<T> factory) {
        super(path, id, factory);
    }

    /**
     * Saves a {@code config} at the {@code path} with current {@code localManager}.
     *
     * @throws ConfigIOException if {@link java.io.IOException} occurred or {@code path} is not valid
     */
    public void save() {
        getLocalManagerOrDefault().save(path,config);
    }

    @Override
    public boolean isMutable() {
        return true;
    }
}
