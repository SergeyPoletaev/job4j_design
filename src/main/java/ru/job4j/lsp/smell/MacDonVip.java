package ru.job4j.lsp.smell;

import java.time.LocalDateTime;

public class MacDonVip extends MacDon {

    public MacDonVip(LocalDateTime startTime) {
        super(startTime);
    }

    /**
     * Нарушение LSP.
     * Производный тип усилил ограничение на вх.параметры переопределяемого метода, тем самым нарушил контракт
     * поведения супертипа. Клиентский код при замене MacDon на MacDonVip и при сумме заказа 200 будет ожидать выполнение
     * заказа, но получит ошибку.
     */
    @Override
    public void cook(Order order) {
        if (order.getTotal() <= 500) {
            throw new IllegalStateException("Заказ не может быть выполнен!");
        }
        super.cook(order);
    }
}
