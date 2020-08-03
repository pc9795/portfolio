package com.prashantchaubey.caches.core;

import java.util.HashMap;
import java.util.Map;

public abstract class SimpleMapCache<X> implements Cache<CacheKey, X> {

    private Map<String, X> cache = new HashMap<>();

    @Override
    public X get(CacheKey key) {
        String keyStr = key.toString();

        if (!cache.containsKey(keyStr)) {
            cache.put(keyStr, load(key));
        }

        return cache.get(keyStr);
    }
}
