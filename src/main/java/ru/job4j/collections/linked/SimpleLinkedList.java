package ru.job4j.collections.linked;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {
    private Node<E> first;
    private Node<E> last;
    private int modCount;
    private int size;

    @Override
    public void add(E value) {
        if (first == null) {
            first = new Node<>(null, value, null);
            last = first;
        } else {
            Node<E> l = last;
            Node<E> newNode = new Node<>(l, value, null);
            last.next = newNode;
            last = newNode;
        }
        modCount++;
        size++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        E result = null;
        int count = 0;
        for (E el : this) {
            if (count == index) {
                result = el;
                break;
            }
            count++;
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int count = 0;
            private Node<E> currentEl = first;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return count < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E rsl = currentEl.value;
                currentEl = currentEl.next;
                count++;
                return rsl;
            }
        };
    }

    static class Node<E> {
        Node<E> prev;
        E value;
        Node<E> next;

        public Node(Node<E> prev, E value, Node<E> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }
}
