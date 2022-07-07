package ru.job4j.lsp.smell;

public class DeliveryService {
    private Restaurant restaurant;

    public DeliveryService(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void deliver(Order order) {
        restaurant.deliver(order);
        /* логика доставки до клиента */
    }
}
