package ru.job4j.lsp.foodstorage;

import java.util.List;

public interface Store {

    void add(Food food);

    List<Food> findAll();
}
