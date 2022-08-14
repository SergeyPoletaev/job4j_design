package ru.job4j.dip.shop.service;

import ru.job4j.dip.shop.model.User;
import ru.job4j.dip.shop.store.UserStore;

public class UserServiceImpl implements UserService {
    private final UserStore store;

    public UserServiceImpl(UserStore store) {
        this.store = store;
    }

    @Override
    public boolean add(User user) {
        return store.add(user);
    }

    @Override
    public boolean remove(int id) {
        return store.remove(id);
    }
}
