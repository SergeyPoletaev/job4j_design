package ru.job4j.lsp.foodstorage;

import java.util.ArrayList;
import java.util.List;

public class TransitStoreInMemory implements TransitStore {
    private final List<Food> container = new ArrayList<>();

    @Override
    public boolean addAll(List<Food> foods) {
        return container.addAll(foods);
    }

    @Override
    public List<Food> findAll() {
        return new ArrayList<>(container);
    }
}
