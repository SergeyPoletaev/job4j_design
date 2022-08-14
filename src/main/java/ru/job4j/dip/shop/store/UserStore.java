package ru.job4j.dip.shop.store;

import ru.job4j.dip.shop.model.User;

public interface UserStore {

    boolean add(User user);

    boolean remove(int id);
}
