package net.crsimple.nyahlib.api.config;

import net.minecraft.util.Identifier;

import java.util.Objects;

/**
 * @since 1.0a
 */
public class ConfigInitializer {
    /**
     * Creates a configuration instance for your mutable config.
     * <p>Only for Mutable config types.</p>
     * <b>Identifier example:</b>
     * <pre>
     * {@code Identifier.of("my_mod","folder/config.json");}
     * </pre>
     *
     * @param id the resource identifier of the config file; may include subdirectories
     *           (e.g. {@code "folder/config.json"}; mustn't start with {@code /}
     * @param factory the factory of your config
     * @return {@link MutableConfigInstance} of your config
     * @throws NullPointerException if {@code id} or {@code factory} is null
     */
    public static <T extends Configuration> ConfigInstance<T> registerMutable(Identifier id, ConfigFactory<T> factory) {
        nullCheck(id,factory);
        return new MutableConfigInstance<>(id.getPath(),id,factory);
    }
    /**
     * Creates a configuration instance for your immutable config.
     * <p>Only for immutable config types.</p>
     * <b>Identifier example:</b>
     * <pre>
     * {@code Identifier.of("my_mod","folder/config.json");}
     * </pre>
     *
     * @param id the resource identifier of the config file; may include subdirectories
     *           (e.g. {@code "folder/config.json"}; mustn't start with {@code /}
     * @param factory the factory of your config
     * @return {@link ImmutableConfigInstance} of your config
     * @throws NullPointerException if {@code id} or {@code factory} is null
     */
    public static <T extends Configuration> ConfigInstance<T> registerImmutable(Identifier id, ConfigFactory<T> factory) {
        nullCheck(id,factory);
        return new ImmutableConfigInstance<>(id.getPath(),id,factory);
    }

    private static void nullCheck(Identifier id,ConfigFactory<?> factory) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(factory);
    }
}
