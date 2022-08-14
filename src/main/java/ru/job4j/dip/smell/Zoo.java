package ru.job4j.dip.smell;

import java.util.ArrayList;

public class Zoo {
    /**
     * Тип ссылки ArrayList - это конкретная реализация интерфейса List.
     * Здесь как минимум нужно использовать ссылку типа List. Либо вообще выделить отдельную абстракцию для хранилища.
     */
    private final ArrayList<Animal> pets = new ArrayList<>();

    /**
     * Тип ссылки входного парамера - конкретная реализация класса Animal. Здесь нужно использовать тип ссылки Animal,
     * таким образом метод станет более универсальным.
     */
    public void feed(Cat cat) {

    }

    /**
     * Тип ссылки возвращаемого методом значения весьма конкретный. Здесь нужно использовать тип ссылки Park, тогда
     * метод будет более универсальным.
     */
    public NationalPark resettle(Animal animal) {
        return null;
    }
}
