package net.crsimple.nyahlib.api.construction;

import java.util.Arrays;

public class ConstructionLayerPattern<K,V> extends PatternWithKeys<K,V> {
    protected ConstructionLayerPattern(Key<K>[][] pattern, KeyTable<K, V> keyTable) {
        super(pattern, keyTable);
    }

    public ConstructionLayerPattern(Builder<K,V> builder) {
        this(builder.pattern,builder.keyTable);
    }

    public static <K,V> Builder<K,V> builder(int size) {
        return new Builder<>(size);
    }

    public static class Builder<K,V> {
        private int current;
        private final int size;
        private final Key<K>[][] pattern;
        private KeyTable<K,V> keyTable;

        @SuppressWarnings("unchecked")
        public Builder(int size) {
            this.size = size;
            this.pattern = (Key<K>[][]) new Key[size][size];
        }

        @SuppressWarnings("unchecked")
        public Builder<K,V> line(K... arr) {
            return line(Arrays.stream(arr)
                    .map(Key::new)
                    .toArray(Key[]::new));
        }

        @SafeVarargs
        public final Builder<K,V> line(Key<K>... arr) {
            if (arr.length >= size) {
                throw new IllegalArgumentException("line length greater than size");
            }
            pattern[current++] = arr;
            return this;
        }

        public Builder<K,V> keyTable(KeyTable<K,V> keyTable) {
            this.keyTable = keyTable;
            return this;
        }

        public ConstructionLayerPattern<K,V> build() {
            return new ConstructionLayerPattern<>(this);
        }

        public KeyTable<K, V> getKeyTable() {
            return keyTable;
        }

        public Key<K>[][] getPattern() {
            return pattern;
        }

        public int getSize() {
            return size;
        }
    }
}
