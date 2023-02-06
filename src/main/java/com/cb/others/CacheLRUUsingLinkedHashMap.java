package com.cb.others;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class CacheLRUUsingLinkedHashMap<K, V> {
    private Map<K, V> map;

    private int size;

    public CacheLRUUsingLinkedHashMap(int size) {
        this.map = new LinkedHashMap<>(size);
        this.size = size;

    }

    public void add(K k, V v) {
        if (map.containsKey(k)) {
            map.remove(k);
        } else if (map.size() == size) {
            var lruKey = map.keySet().iterator().next();
            map.remove(lruKey);
        }
        map.put(k, v);
    }

    public V get(K k) {
        if (!map.containsKey(k))
            return null;
        var v = map.get(k);
        map.remove(k);
        map.put(k, v);
        return v;
    }

    public Collection<V> list() {
        return map.values();
    }

    public static void main(String[] args) {
        CacheLRUUsingLinkedHashMap<Integer, Integer> cache = new CacheLRUUsingLinkedHashMap<>(3);
        cache.add(1, 1);
        cache.add(2, 2);
        cache.add(3, 3);
        System.out.println(cache.list());
        System.out.println(cache.get(1));
        cache.add(4, 4);
        System.out.println(cache.list());
        cache.add(3, 33);
        cache.add(5, 5);
        cache.add(6, 6);
        System.out.println(cache.list());
    }
}
