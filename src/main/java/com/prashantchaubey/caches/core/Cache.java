package com.prashantchaubey.caches.core;

public interface Cache<X extends CacheKey, Y> {
  Y load(X key);

  Y get(X key);
}
