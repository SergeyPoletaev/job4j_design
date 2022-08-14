package ru.job4j.dip.shop.service;

import ru.job4j.dip.shop.model.Order;
import ru.job4j.dip.shop.model.Product;

public interface OrderService {

    boolean addOrder(Order order);

    boolean addProduct(Order order, Product product);

    boolean removeProduct(Order order, Product product);

    boolean remove(Order order);

    void clear();
}
