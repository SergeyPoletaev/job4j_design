package ru.job4j.io.duplicates;

import java.util.Objects;

public class FileProperty {
    private final long size;
    private final String name;

    public FileProperty(long size, String name) {
        this.size = size;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FileProperty property = (FileProperty) o;
        return size == property.size && Objects.equals(name, property.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, name);
    }
}
