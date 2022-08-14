package ru.job4j.dip.shop.store;

import ru.job4j.dip.shop.model.Order;
import ru.job4j.dip.shop.model.Product;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OrderStoreImpl implements OrderStore {
    private final Map<Order, Set<Product>> orders = new HashMap<>();

    @Override
    public boolean addOrder(Order order) {
        if (orders.containsKey(order)) {
            return false;
        }
        return orders.put(order, new HashSet<>()) == null;
    }

    @Override
    public boolean addProduct(Order order, Product product) {
        Set<Product> products = getProducts(order);
        return products.add(product);
    }

    @Override
    public boolean removeProduct(Order order, Product product) {
        Set<Product> products = getProducts(order);
        return products.remove(product);
    }

    @Override
    public Set<Product> getProducts(Order order) {
        return orders.getOrDefault(order, Set.of());
    }

    @Override
    public boolean remove(Order order) {
        return orders.remove(order) != null;
    }

    @Override
    public void clear() {
        orders.clear();
    }
}
