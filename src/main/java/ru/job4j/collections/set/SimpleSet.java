package ru.job4j.collections.set;

import ru.job4j.collections.array.SimpleArrayList;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Set<T> {
    private static final int INITIAL_CAPACITY = 10;
    private final SimpleArrayList<T> set = new SimpleArrayList<>(INITIAL_CAPACITY);

    @Override
    public boolean add(T value) {
        boolean rsl = !contains(value);
        if (rsl) {
            set.add(value);
        }
        return rsl;
    }

    @Override
    public boolean contains(T value) {
        boolean rsl = false;
        for (T el : set) {
            if (Objects.equals(el, value)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
