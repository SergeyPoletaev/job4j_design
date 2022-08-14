package ru.job4j.dip.shop.service;

import ru.job4j.dip.shop.model.User;

public interface UserService {

    boolean add(User user);

    boolean remove(int id);
}
