package ru.job4j.dip.shop.service;

import ru.job4j.dip.shop.model.Product;

public interface ProductService {

    boolean add(Product product);

    boolean remove(int id);
}
