package ru.job4j.generics;

public class Product extends Base {
    private final String name;
    private final String color;

    public Product(String id, String name, String color) {
        super(id);
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
}
