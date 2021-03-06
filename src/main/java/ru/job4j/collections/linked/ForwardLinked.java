package ru.job4j.collections.linked;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public void addFirst(T value) {
        head = new Node<>(value, head);
    }

    public T deleteFirst() {
        if (head != null) {
            Node<T> node = head.next;
            T value = head.value;
            head.next = null;
            head.value = null;
            head = node;
            return value;
        }
        throw new NoSuchElementException();
    }

    public boolean revert() {
        boolean rsl = head != null && head.next != null;
        if (rsl) {
            Node<T> curr = head.next;
            head.next = null;
            while (curr != null) {
                Node<T> next = curr.next;
                curr.next = head;
                head = curr;
                curr = next;
            }
        }
        return rsl;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
