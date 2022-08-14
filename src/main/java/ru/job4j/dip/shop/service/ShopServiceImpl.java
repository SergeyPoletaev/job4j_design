package ru.job4j.dip.shop.service;

import org.apache.log4j.Logger;
import ru.job4j.dip.shop.model.Check;
import ru.job4j.dip.shop.model.Order;
import ru.job4j.dip.shop.model.Product;
import ru.job4j.dip.shop.model.User;
import ru.job4j.dip.shop.store.ShopStore;

import java.util.Optional;
import java.util.Set;

public class ShopServiceImpl implements ShopService {
    private static final Logger LOGGER = Logger.getLogger("Shop logger");
    private final ShopStore store;
    private final CheckService checkService;
    private final OrderService orderService;
    private final ProductService productService;
    private final UserService userService;

    public ShopServiceImpl(ShopStore store,
                           CheckService checkService,
                           OrderService orderService,
                           ProductService productService,
                           UserService userService) {
        this.store = store;
        this.checkService = checkService;
        this.orderService = orderService;
        this.productService = productService;
        this.userService = userService;
    }

    @Override
    public boolean createBucket(User user) {
        return store.saveUser(user);
    }

    @Override
    public boolean createOrder(User user, Order order) {
        return store.saveOrder(user, order);
    }

    @Override
    public boolean addProduct(User user, Order order, Product product) {
        Set<Order> orders = store.getOrders(user);
        if (orders.contains(order)) {
            return orderService.addProduct(order, product);
        }
        return false;
    }

    @Override
    public boolean removeProduct(User user, Order order, Product product) {
        Set<Order> orders = store.getOrders(user);
        if (orders.contains(order)) {
            return orderService.removeProduct(order, product);
        }
        return false;
    }

    @Override
    public boolean removeOrder(User user, Order order) {
        Set<Order> orders = store.getOrders(user);
        if (orders.contains(order)) {
            return orders.remove(order);
        }
        return false;
    }

    @Override
    public Check payOrder(User user, Order order) {
        Optional<Order> orderDB = findOrder(user, order);
        if (orderDB.isEmpty()) {
            System.out.println("Get error with " + user + " " + order);
            throw new IllegalArgumentException("Invalid order");
        }
        if (orderDB.get().isPayed()) {
            System.out.println("Get error with " + user + " " + order);
            throw new IllegalArgumentException("Already payed!");
        }
        orderDB.get().setPayed(true);
        Check check = new Check((int) (System.currentTimeMillis() % 1000_000), "Payed: " + orderDB.get().getId());
        checkService.add(check);
        return check;
    }

    private Optional<Order> findOrder(User user, Order order) {
        return store.getOrders(user).stream().filter(o -> o.equals(order)).findFirst();
    }
}
