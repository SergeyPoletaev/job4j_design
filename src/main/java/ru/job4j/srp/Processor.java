package ru.job4j.srp;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Назначение этого класса расчет стоимости заказа.
 * Наличие в классе метода cleanBasket() нарушает принцип SRP.
 */
public class Processor {

    public int calc(Product product, int count) {
        return product.getPrice() * count;
    }

    public int discount(int start, int finish) {
        return ThreadLocalRandom.current().nextInt(start, finish);
    }

    public int total(int orderCost, int discount) {
        return orderCost * (discount / 100);
    }

    public void cleanBasket() {
        /* логика очистки корзины с заказами */
    }
}
