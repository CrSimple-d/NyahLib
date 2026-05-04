package net.crsimple.nyahlib.api.construction;

import java.util.Map;

public abstract class KeyTable<K,V> {
    protected final Map<Key<K>,V> table;

    protected KeyTable(Map<Key<K>, V> table) {
        this.table = table;
    }
    public V get(Key<K> key) {
        return table.get(key);
    }
    public boolean isEmpty() {
        return table.isEmpty();
    }
}
