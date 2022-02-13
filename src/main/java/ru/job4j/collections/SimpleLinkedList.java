package ru.job4j.collections;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<T> implements List<T> {
    private Node<T> first;
    private Node<T> last;
    private int modCount;
    private int size;

    @Override
    public void add(T value) {
        if (first == null) {
            first = new Node<>(null, value, null);
            last = first;
        } else {
            Node<T> l = last;
            Node<T> newNode = new Node<>(l, value, null);
            last.next = newNode;
            last = newNode;
        }
        modCount++;
        size++;
    }

    @Override
    public T set(int index, T newValue) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        T rsl = null;
        Iterator<T> it = iterator();
        int count = 0;
        while (it.hasNext()) {
            if (count == index) {
                rsl = it.next();
                break;
            }
            it.next();
            count++;
        }
        return rsl;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int count = 0;
            private Node<T> currentEl = first;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return count < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T rsl = currentEl.value;
                currentEl = currentEl.next;
                count++;
                return rsl;
            }
        };
    }

    static class Node<T> {
        Node<T> prev;
        T value;
        Node<T> next;

        public Node(Node<T> prev, T value, Node<T> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }
}
