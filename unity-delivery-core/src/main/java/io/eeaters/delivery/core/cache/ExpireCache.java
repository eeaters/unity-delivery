package io.eeaters.delivery.core.cache;

import java.util.Collection;
import java.util.Map;

/**
 * 目前是为了使用缓存的时候可以默认使用本地cache。同时能够基于spi的方式，允许使用者进行任意扩展
 * @param <V>
 */
public interface ExpireCache<V> {

    void put(String key, V value, long expireAfterMillions);

    V get(String key);

    Map<String,V> list(Collection<String> keys);

    void remove(String key);

    void removeAll();

}
