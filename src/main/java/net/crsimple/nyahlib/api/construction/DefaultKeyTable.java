package net.crsimple.nyahlib.api.construction;

import java.util.HashMap;
import java.util.Map;

public class DefaultKeyTable<K,V> extends KeyTable<K,V> {
    public DefaultKeyTable(Map<Key<K>, V> table) {
        super(table);
    }
    public DefaultKeyTable() {
        this(new HashMap<>());
    }
}
