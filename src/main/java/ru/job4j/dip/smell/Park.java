package ru.job4j.dip.smell;

import java.util.Objects;

public abstract class Park {
    private final String name;

    public Park(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Park park = (Park) o;
        return Objects.equals(name, park.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
