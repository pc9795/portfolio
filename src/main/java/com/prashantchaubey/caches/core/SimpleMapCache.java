package com.prashantchaubey.caches.core;

import java.util.HashMap;
import java.util.Map;

public abstract class SimpleMapCache<X extends CacheKey, Y> implements Cache<X, Y> {
  private Map<String, Y> cache = new HashMap<>();

  @Override
  public Y get(X cacheKey) {
    String keyStr = cacheKey.getKeyStr();

    if (!cache.containsKey(keyStr)) {
      cache.put(keyStr, load(cacheKey));
    }

    return cache.get(keyStr);
  }

  @Override
  public void delete(X cacheKey) {
    cache.remove(cacheKey.getKeyStr());
  }

  @Override
  public void clear() {
    cache.clear();
  }
}
