package ru.job4j.dip.shop.service;

import ru.job4j.dip.shop.model.Product;
import ru.job4j.dip.shop.store.ProductStore;

public class ProductServiseImpl implements ProductService {
    private final ProductStore store;

    public ProductServiseImpl(ProductStore store) {
        this.store = store;
    }

    @Override
    public boolean add(Product product) {
        return store.add(product);
    }

    @Override
    public boolean remove(int id) {
        return store.remove(id);
    }
}
