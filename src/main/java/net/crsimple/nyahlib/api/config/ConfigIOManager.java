package net.crsimple.nyahlib.api.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.crsimple.nyahlib.LibMain;
import net.fabricmc.loader.api.FabricLoader;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

/**
 *  Configuration Reader / Writer using GSON with at specified anchor path
 *
 * @since 1.0a
 */
public interface ConfigIOManager {
    //default instance of ConfigIOManager
    ConfigIOManager INSTANCE = new Impl();

    /**
     * <p>Serializes config to json with {@link Gson#toJson} and writes it to the file at the resolved path.<br>
     * Creates intermediate directories if do not exists</p>
     *
     * @param additional relative path to the file, resolved with {@link #config()}
     * @param config object to serialize through {@link Gson}
     * @throws ConfigIOException if {@link IOException} occurred during file writing
     * @throws NullPointerException if {@code additional} or {@code config} is null
     */
    default void save(String additional,Object config) throws ConfigIOException {
        Objects.requireNonNull(config);
        Objects.requireNonNull(additional);

        Path path = config().resolve(additional);
        checkPath(path);
        try {
            Files.createDirectories(path.getParent());
            Files.writeString(path,gson().toJson(config));
        } catch (IOException e) {
            throw new ConfigIOException("Failed to save config at path: " + path,e);
        }
    }

    /**
     * <p>Loads config object from JSON file with {@link #load}.
     * If file does not exist saves {@code fallback} through {@link #save} before loading.
     *
     * @param additional relative path to the file, resolved against {@link #config()}
     * @param fallback default value, returned if the file does not exist; must be not null
     * @return deserialized object of type {@code <T>} from the JSON file,
     * {@code fallback} if the file does not exist
     * @throws ConfigIOException if an {@link IOException} occurs during file reading or saving,
     * or the path doesn't point to a valid JSON file
     * @throws NullPointerException if {@code additional} or {@code fallback} is null
     * @see #load
     * @see #save
     */
    default @NotNull <T> T loadWithSave(String additional, T fallback) throws ConfigIOException {
        Objects.requireNonNull(additional);
        Objects.requireNonNull(fallback);

        Path path = config().resolve(additional);
        if (Files.notExists(path)) {
            save(additional,fallback);
        }
        return load(additional,fallback);
    }

    /**
     * <p>Reads and deserializes a config object from JSON file with {@link Gson#fromJson}
     *
     * @param additional relative path to the file, resolved against {@link #config()}
     * @param fallback default value, returned if the file does not exist; must be not null
     * @return deserialized object of type {@code <T>} from the JSON file,
     * {@code fallback} if the file does not exist
     * @throws ConfigIOException if an {@link IOException} occurs during file reading,
     * or the path doesn't point to a valid JSON file
     * @throws NullPointerException if {@code additional} or {@code fallback} is null
     * @see #loadWithSave
     */
    @SuppressWarnings("unchecked")
    default @NotNull <T> T load(String additional,T fallback) throws ConfigIOException {
        Objects.requireNonNull(additional);
        Objects.requireNonNull(fallback);

        Path path = config().resolve(additional);
        checkPath(path);
        try {
            if (Files.exists(path)) {
                return (T) gson().fromJson(Files.newBufferedReader(path),fallback.getClass());
            }
            LibMain.LOGGER.warn("Config doesn't exist at path: {}", path);
        } catch (IOException e) {
            throw new ConfigIOException("Failed to load config at path: " + path,e);
        }
        LibMain.LOGGER.warn("Using default config for {}", path);
        return fallback;
    }

    //checks that the file path is correct
    private void checkPath(Path path) {
        if ((Files.exists(path) && !path.toFile().isFile()) || !path.toString().endsWith(".json")) {
            throw new ConfigIOException("Bad path: " + path + "; Possible solution: File should be .json");
        }
    }

    /**
     * @return GSON instance
     */
    @NotNull Gson gson();

    /**
     * @return path to config file or directory
     */
    @NotNull Path config();

    /**
     * Default implementation of {@link ConfigIOManager}
     * with a fabric default configuration folder path
     * and pretty printing GSON
     *
     * @since 1.0a
     */
    class Impl implements ConfigIOManager {
        private final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir();
        private final Gson GSON;

        private Impl() {
            this(new GsonBuilder().setPrettyPrinting().create());
        }

        public Impl(Gson gson) {
            GSON = gson;
        }

        /**
         * @return GSON with pretty printing
         */
        @Override
        public @NotNull Gson gson() {
            return GSON;
        }

        /**
         * @return path to fabric configuration directory
         */
        @Override
        public @NotNull Path config() {
            return CONFIG_PATH;
        }
    }
}
