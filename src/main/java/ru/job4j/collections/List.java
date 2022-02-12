package ru.job4j.collections;

public interface List<T> extends Iterable<T> {

    void add(T value);

    T set(int index, T newValue);

    T remove(int index);

    T get(int index);

    int size();
}
