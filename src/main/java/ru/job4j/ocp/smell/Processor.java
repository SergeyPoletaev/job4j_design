package ru.job4j.ocp.smell;

import java.util.ArrayList;

public class Processor<T> {
    /**
     * Если поменяется реализация входных данных, например на LinkedList, то придется вносить изменения в класс.
     * Тем самым нарушается принцип ОСР.
     * Нужно в качестве типа данных здесь использовать тип интерфейса List, а не конкретной реализации.
     */
    private final ArrayList<T> list;

    public Processor(ArrayList<T> list) {
        this.list = list;
    }

    public void add(T elem) {
        list.add(elem);
    }
}
