package ru.job4j.dip.shop.store;

import ru.job4j.dip.shop.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserStoreImpl implements UserStore {
    private final Map<Integer, User> users = new HashMap<>();

    @Override
    public boolean add(User user) {
        if (users.containsKey(user.getId())) {
            return false;
        }
        return users.put(user.getId(), user) == null;
    }

    @Override
    public boolean remove(int id) {
        return users.remove(id) != null;
    }
}
