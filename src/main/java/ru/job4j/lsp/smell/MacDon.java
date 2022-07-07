package ru.job4j.lsp.smell;

import java.time.LocalDateTime;

public class MacDon extends Restaurant {

    public MacDon(LocalDateTime startTime) {
        super(startTime);
    }

    /**
     * Органичение по предусловию: Сумма заказа должна быть > 100
     */
    @Override
    public void cook(Order order) {
        if (order.getTotal() <= 100) {
            throw new IllegalStateException("Заказ не может быть выполнен!");
        }
        /* логика приготовления еды в ресторане MacDon */
    }

    /**
     * Нарушение LSP.
     * Производный тип должен как минимум гарантировать то что умеет супертип. А у нас производный тип не выполняет
     * контракт поведения определенный в супертипе, т.к. в поведении подтипа не предусмотрена доставка еды.
     * Мы не можем безопасно заменить в клиентском коде Restorant на MacDon. Программа упадет с ошибкой.
     */
    @Override
    public void deliver(Order order) {
        throw new UnsupportedOperationException("В ресторане MacDon доставка не осуществляется");
    }
}
