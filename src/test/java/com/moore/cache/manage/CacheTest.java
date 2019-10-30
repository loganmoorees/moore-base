package com.moore.cache.manage;

import com.moore.cache.LRUCache;
import org.junit.Test;

public class CacheTest {

    @Test
    public void cache() {
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "1=1");
        cache.put(2, "2=2");
        cache.put(3, "3=3");
        cache.get(1);
        cache.put(4, "4=4");
    }
}
