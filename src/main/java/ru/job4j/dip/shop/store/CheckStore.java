package ru.job4j.dip.shop.store;

import ru.job4j.dip.shop.model.Check;

import java.util.Optional;

public interface CheckStore {

    boolean add(Check check);

    boolean remove(int id);

    Optional<Check> findById(int id);
}
