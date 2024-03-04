package io.eeaters.delivery.core.cache;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * 一个简单的本地缓存
 * @param <V>
 */
public class LocalCacheExpireCache<V> implements ExpireCache<V>{

    private final Map<String, CacheEntry<V>> cache = new ConcurrentHashMap<>();

    @Override
    public void put(String key, V value, long expireAfterMillions) {
        long expireTime = System.currentTimeMillis() + expireAfterMillions;
        cache.put(key, new CacheEntry<>(value, expireTime));
    }

    @Override
    public V get(String key) {
        CacheEntry<V> entry = cache.get(key);
        if (entry != null && !entry.isExpired()) {
            return entry.getValue();
        }
        return null;
    }

    @Override
    public Map<String, V> list(Collection<String> keys) {
        return keys.stream()
                .collect(Collectors.toMap(key -> key, this::get));
    }

    @Override
    public void remove(String key) {
        cache.remove(key);
    }

    @Override
    public void removeAll() {
        cache.keySet().forEach(this::remove);
    }



    private static class CacheEntry<V> {
        private final V value;
        private final long expireTime;

        public CacheEntry(V value, long expireTime) {
            this.value = value;
            this.expireTime = expireTime;
        }

        public V getValue() {
            return value;
        }

        public boolean isExpired() {
            return System.currentTimeMillis() >= expireTime;
        }
    }
}
