package ru.job4j.lsp.parking;

public class Truck implements Vehicle {
    private final int size;

    public Truck(int size) {
        if (size <= Size.ONE.getValue()) {
            throw new IllegalArgumentException(
                    String.format("Размер грузового автомобиля должен быть более %s", Size.ONE.getValue())
            );
        }
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }
}
