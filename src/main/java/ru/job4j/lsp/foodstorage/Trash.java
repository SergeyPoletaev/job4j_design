package ru.job4j.lsp.foodstorage;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {
    private final List<Food> container = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        boolean check = accept(food);
        if (check) {
            container.add(food);
        }
        return check;
    }

    @Override
    public List<Food> findAll() {
        return new ArrayList<>(container);
    }

    @Override
    public void clear() {
        container.clear();
    }

    @Override
    public boolean accept(Food food) {
        return verification(food) >= Bound.ONE_HUNDRED.getValue();
    }
}
