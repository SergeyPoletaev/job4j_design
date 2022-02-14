package ru.job4j.collections.linked;

public class SimpleStack<T> {
    private final ForwardLinked<T> linked = new ForwardLinked<>();

    public void push(T value) {
        linked.addFirst(value);
    }

    public T pop() {
        return linked.deleteFirst();
    }
}
