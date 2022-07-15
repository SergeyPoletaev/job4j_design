package ru.job4j.lsp.parking;

public enum Size {
    ONE(1);

    private final int value;

    Size(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
