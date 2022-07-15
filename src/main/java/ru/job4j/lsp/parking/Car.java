package ru.job4j.lsp.parking;

public class Car implements Vehicle {
    private final int size = Size.ONE.getValue();

    @Override
    public int getSize() {
        return size;
    }
}
