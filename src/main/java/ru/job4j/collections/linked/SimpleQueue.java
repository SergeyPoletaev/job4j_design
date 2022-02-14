package ru.job4j.collections.linked;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int sizeIn = 0;
    private int sizeOut = 0;

    public void push(T value) {
        in.push(value);
        sizeIn++;
    }

    public T poll() {
        if (sizeIn == 0 && sizeOut == 0) {
            throw new NoSuchElementException();
        }
        if (sizeOut == 0) {
            while (sizeIn > 0) {
                out.push(in.pop());
                sizeOut++;
                sizeIn--;
            }
        }
        sizeOut--;
        return out.pop();
    }
}
