package com.moore.cache;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * LRU缓存LinkedHashMap实现
 *
 * @param <K>
 * @param <V>
 */
public class MapCache<K, V> extends LinkedHashMap<K, V> {

    private final int MAX_CACHE_SIZE;


    public MapCache(int cacheSize) {
        super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
        MAX_CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Entry eldest) {
        return size() > MAX_CACHE_SIZE;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Entry<K, V> entry : entrySet()) {
            sb.append(String.format("%s:%s ", entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }
}
