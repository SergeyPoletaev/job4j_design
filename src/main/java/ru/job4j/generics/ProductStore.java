package ru.job4j.generics;

public class ProductStore implements Store<Product> {
    private final Store<Product> store = new MemStore<>();

    @Override
    public void add(Product model) {
        store.add(model);
    }

    @Override
    public boolean replace(String id, Product model) {
        return store.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return store.delete(id);
    }

    @Override
    public Product findById(String id) {
        return store.findById(id);
    }
}
