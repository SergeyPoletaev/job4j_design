package ru.job4j.lsp.foodstorage;

public enum Bound {
    TWENTY_FIVE(25),
    SEVENTY_FIVE(75),
    ONE_HUNDRED(100);

    private final int value;

    Bound(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
