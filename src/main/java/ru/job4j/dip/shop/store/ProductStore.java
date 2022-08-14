package ru.job4j.dip.shop.store;

import ru.job4j.dip.shop.model.Product;

public interface ProductStore {

    boolean add(Product product);

    boolean remove(int id);
}
