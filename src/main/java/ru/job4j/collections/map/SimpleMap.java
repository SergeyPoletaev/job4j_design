package ru.job4j.collections.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleMap<K, V> implements Map<K, V> {
    private static final float LOAD_FACTOR = 0.75F;
    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (count >= capacity * LOAD_FACTOR) {
            resize();
        }
        int hi = hash(key, table);
        boolean rsl = table[hi] == null;
        if (rsl) {
            table[hi] = new MapEntry<>(key, value);
            modCount++;
            count++;
        }
        return rsl;
    }

    @Override
    public V get(K key) {
        MapEntry<K, V> entry = table[hash(key, table)];
        return entry != null && Objects.equals(entry.key, key) ? entry.value : null;
    }

    @Override
    public boolean remove(K key) {
        int hi = hash(key, table);
        boolean rsl = table[hi] != null && Objects.equals(table[hi].key, key);
        if (rsl) {
            table[hi] = null;
            modCount++;
            count--;
        }
        return rsl;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            private final int expectedModCount = modCount;
            private int index = 0;
            private int total = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (index < table.length && table[index] == null) {
                    index++;
                }
                return total < count;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                total++;
                return table[index++].key;
            }
        };
    }

    private void resize() {
        capacity = capacity * 2;
        MapEntry<K, V>[] newTable = new MapEntry[capacity];
        for (MapEntry<K, V> entry : table) {
            if (entry != null) {
                int hi = hash(entry.key, newTable);
                newTable[hi] = entry;
            }
        }
        table = newTable;
    }

    private int hash(K key, MapEntry<K, V>[] table) {
        int rsl = 0;
        if (key != null) {
            int h1 = key.hashCode();
            int h2 = h1 >>> 16;
            int h3 = h1 ^ h2;
            rsl = h3 & (table.length - 1);
        }
        return rsl;
    }


    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
