package ru.job4j.dip.shop;


import ru.job4j.dip.shop.model.Check;
import ru.job4j.dip.shop.model.Order;
import ru.job4j.dip.shop.model.Product;
import ru.job4j.dip.shop.model.User;
import ru.job4j.dip.shop.service.*;
import ru.job4j.dip.shop.store.*;

public class App {

    public static void main(String[] args) {
        /* создали модели */
        User user1 = new User(1, "Anna");
        Product product1 = new Product(3, "Apple");
        Product product2 = new Product(4, "Orange");
        Order order1 = new Order(10);
        Order order2 = new Order(20);

        /* создали сервисы */
        UserService userService = new UserServiceImpl(new UserStoreImpl());
        ProductService productService = new ProductServiseImpl(new ProductStoreImpl());
        OrderService orderService = new OrderServiceImpl(new OrderStoreImpl());

        /* заполнили хранилища */
        userService.add(user1);
        productService.add(product1);
        productService.add(product2);
        orderService.addOrder(order1);
        orderService.addOrder(order2);

        /* создали общий сервис магазина */
        ShopService shopService = new ShopServiceImpl(
                new ShopStoreImpl(),
                new CheckServiceImpl(new CheckStoreImpl()),
                orderService, productService, userService);

        /* сама программа */
        boolean r1 = shopService.createBucket(user1);
        boolean r2 = shopService.createOrder(user1, order1);
        boolean r3 = shopService.createOrder(user1, order2);
        boolean r4 = shopService.addProduct(user1, order1, product1);
        boolean r5 = shopService.addProduct(user1, order1, product2);
        boolean r6 = shopService.removeProduct(user1, order1, product1);
        boolean r7 = shopService.removeOrder(user1, order1);
        Check r8 = shopService.payOrder(user1, order2);
    }
}
