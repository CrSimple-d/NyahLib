package net.crsimple.nyahlib.api.construction;

public abstract class PatternWithKeys<K,V> extends Pattern<Key<K>> {
    protected final KeyTable<K,V> keyTable;

    protected PatternWithKeys(Key<K>[][] pattern, KeyTable<K, V> keyTable) {
        super(pattern);
        this.keyTable = keyTable;
    }
}
