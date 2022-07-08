package ru.job4j.lsp.foodstorage;

import java.util.ArrayList;
import java.util.List;

public class WareHouse implements Store {
    private final List<Food> container = new ArrayList<>();

    @Override
    public void add(Food food) {
        container.add(food);
    }

    @Override
    public List<Food> findAll() {
        return new ArrayList<>(container);
    }
}
