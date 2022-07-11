package ru.job4j.lsp.foodstorage;

import java.util.List;

public interface Store {

    boolean add(Food food);

    boolean accept(Food food);

    List<Food> findAll();

    default double verification(Food food) {
        long createDateInMillis = food.getCreateDate().getTimeInMillis();
        long productLifeTime = food.getExpiryDate().getTimeInMillis() - createDateInMillis;
        long productAge = System.currentTimeMillis() - createDateInMillis;
        return Math.round(((double) productAge * 100 / productLifeTime) * 10) / 10.0;
    }
}
