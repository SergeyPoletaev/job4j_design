package ru.job4j.dip.shop.service;

import ru.job4j.dip.shop.model.Order;
import ru.job4j.dip.shop.model.Product;
import ru.job4j.dip.shop.store.OrderStore;

public class OrderServiceImpl implements OrderService {
    private final OrderStore store;

    public OrderServiceImpl(OrderStore store) {
        this.store = store;
    }

    @Override
    public boolean addOrder(Order order) {
        return store.addOrder(order);
    }

    @Override
    public boolean addProduct(Order order, Product product) {
        return store.addProduct(order, product);
    }

    @Override
    public boolean removeProduct(Order order, Product product) {
        return store.removeProduct(order, product);
    }

    @Override
    public boolean remove(Order order) {
        return store.remove(order);
    }

    @Override
    public void clear() {
        store.clear();
    }
}
