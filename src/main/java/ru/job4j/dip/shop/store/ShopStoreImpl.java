package ru.job4j.dip.shop.store;

import ru.job4j.dip.shop.model.Order;
import ru.job4j.dip.shop.model.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ShopStoreImpl implements ShopStore {
    private final Map<User, Set<Order>> store = new HashMap<>();

    @Override
    public boolean saveUser(User user) {
        if (store.containsKey(user)) {
            return false;
        }
        return store.put(user, new HashSet<>()) == null;
    }

    @Override
    public boolean saveOrder(User user, Order order) {
        Set<Order> orders = getOrders(user);
        return orders.add(order);
    }

    @Override
    public Set<Order> getOrders(User user) {
        return store.getOrDefault(user, Set.of());
    }

    @Override
    public Set<User> getUsers() {
        return store.keySet();
    }
}
