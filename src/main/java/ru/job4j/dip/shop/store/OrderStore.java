package ru.job4j.dip.shop.store;

import ru.job4j.dip.shop.model.Order;
import ru.job4j.dip.shop.model.Product;

import java.util.Set;

public interface OrderStore {

    boolean addOrder(Order order);

    boolean addProduct(Order order, Product product);

    boolean removeProduct(Order order, Product product);

    Set<Product> getProducts(Order order);

    boolean remove(Order order);

    void clear();
}
