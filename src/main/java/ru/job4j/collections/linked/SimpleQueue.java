package ru.job4j.collections.linked;

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
