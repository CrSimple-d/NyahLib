package net.crsimple.nyahlib.util;

import net.crsimple.nyahlib.api.config.InvalidConfigException;

import java.util.Collection;
import java.util.Objects;

public class ConfigHelper {
    public static void stringNonEmpty(String fieldName, String string) throws InvalidConfigException {
        Objects.requireNonNull(string);
        if(string.isEmpty()) {
            throw new InvalidConfigException(fieldName + " is empty!");
        }
    }
    public static void collectionNonEmpty(String fieldName, Collection<?> collection) throws InvalidConfigException {
        if(collection.isEmpty()) {
            throw new InvalidConfigException(fieldName + " is empty!");
        }
    }
    public static void limit(String fieldName, int i, int min, int max) throws InvalidConfigException {
        if(i < min || i > max) {
            throw new InvalidConfigException(String.format("%s must be greater than %d and less than %d!",fieldName,max,min));
        }
    }
}
