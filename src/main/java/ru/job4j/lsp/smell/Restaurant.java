package ru.job4j.lsp.smell;

import java.time.LocalDateTime;

public abstract class Restaurant {
    protected LocalDateTime startTime;

    public Restaurant(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public abstract void cook(Order order);

    public abstract void deliver(Order order);
}
