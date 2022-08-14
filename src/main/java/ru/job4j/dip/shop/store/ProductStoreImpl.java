package ru.job4j.dip.shop.store;

import ru.job4j.dip.shop.model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductStoreImpl implements ProductStore {
    private final Map<Integer, Product> products = new HashMap<>();

    @Override
    public boolean add(Product product) {
        if (products.containsKey(product.getId())) {
            return false;
        }
        return products.put(product.getId(), product) == null;
    }

    @Override
    public boolean remove(int id) {
        return products.remove(id) != null;
    }
}
