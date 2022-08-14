package ru.job4j.dip.shop.service;

import ru.job4j.dip.shop.model.Check;
import ru.job4j.dip.shop.model.Order;
import ru.job4j.dip.shop.model.Product;
import ru.job4j.dip.shop.model.User;

public interface ShopService {

    boolean createBucket(User user);

    boolean createOrder(User user, Order order);

    boolean addProduct(User user, Order order, Product product);

    boolean removeProduct(User user, Order order, Product product);

    boolean removeOrder(User user, Order order);

    Check payOrder(User user, Order order);
}
