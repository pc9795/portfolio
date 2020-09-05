package com.prashantchaubey.caches.core;

public interface Cache<X extends CacheKey, Y> {
  Y load(X cacheKey);

  Y get(X cacheKey);

  void delete(X cacheKey);

  void clear();
}
