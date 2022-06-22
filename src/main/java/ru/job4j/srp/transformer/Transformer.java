package ru.job4j.srp.transformer;

public interface Transformer<T, U> {

    T transform(U u);
}
