package ru.job4j.lsp.smell;

import java.time.LocalDateTime;

public class IlPatio extends Restaurant {

    public IlPatio(LocalDateTime startTime) {
        super(startTime);
    }

    @Override
    public void cook(Order order) {
        /* логика приготовления еды в ресторане IlPatio */
    }

    @Override
    public void deliver(Order order) {
        /* логика передачи в службу доставки */
    }

    /**
     * Нарушение LSP.
     * Данный метод разрешает изменение состояния которое не допускал базовый класс.
     * Клиенты суперкласса не ожидают такого поведения. Безпроблемной замены типов быть не может.
     * Согласно контракту базового класса свойство startTime может быть установлено только один раз при создании
     * объекта и его изменение в течении всей жизни объекта не предусмотрено.
     */
    public void setStartTime(LocalDateTime localDateTime) {
        this.startTime = localDateTime;
    }
}
