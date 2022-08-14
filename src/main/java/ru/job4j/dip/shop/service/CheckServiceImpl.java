package ru.job4j.dip.shop.service;

import ru.job4j.dip.shop.model.Check;
import ru.job4j.dip.shop.store.CheckStore;

import java.util.Optional;

public class CheckServiceImpl implements CheckService {
    private final CheckStore store;

    public CheckServiceImpl(CheckStore store) {
        this.store = store;
    }

    @Override
    public boolean add(Check check) {
        return store.add(check);
    }

    @Override
    public boolean remove(int id) {
        return store.remove(id);
    }

    @Override
    public Optional<Check> findById(int id) {
        return store.findById(id);
    }
}
