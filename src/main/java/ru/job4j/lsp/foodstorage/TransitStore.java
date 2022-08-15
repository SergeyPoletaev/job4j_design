package ru.job4j.lsp.foodstorage;

import java.util.List;

public interface TransitStore {

    boolean addAll(List<Food> foods);

    List<Food> findAll();
}
