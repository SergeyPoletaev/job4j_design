package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;

public class ProductStoreTest {

    @Test
    public void whenAddAndFindThenNameIsApple() {
        ProductStore store = new ProductStore();
        store.add(new Product("1", "Apple", "yellow"));
        Product result = store.findById("1");
        assertThat(result.getName(), is("Apple"));
    }

    @Test
    public void whenAddAndFindThenProductIsNull() {
        ProductStore store = new ProductStore();
        store.add(new Product("1", "Apple", "yellow"));
        Product result = store.findById("10");
        assertNull(result);
    }

    @Test
    public void whenAddDuplicateAndFindNameIsApple() {
        ProductStore store = new ProductStore();
        store.add(new Product("1", "Apple", "yellow"));
        store.add(new Product("1", "Lime", "green"));
        Product result = store.findById("1");
        assertThat(result.getName(), is("Apple"));
    }

    @Test
    public void whenReplaceThenNameIsLime() {
        ProductStore store = new ProductStore();
        store.add(new Product("1", "Apple", "yellow"));
        store.replace("1", new Product("1", "Lime", "green"));
        Product result = store.findById("1");
        assertThat(result.getName(), is("Lime"));
    }

    @Test
    public void whenNoReplaceProductThenNoChangeName() {
        ProductStore store = new ProductStore();
        store.add(new Product("1", "Apple", "yellow"));
        store.replace("10", new Product("10", "Lime", "green"));
        Product result = store.findById("1");
        assertThat(result.getName(), is("Apple"));
    }

    @Test
    public void whenDeleteProductThenProductIsNull() {
        ProductStore store = new ProductStore();
        store.add(new Product("1", "Apple", "yellow"));
        store.delete("1");
        Product result = store.findById("1");
        assertNull(result);
    }

    @Test
    public void whenNoDeleteProductThenNameIsApple() {
        ProductStore store = new ProductStore();
        store.add(new Product("1", "Apple", "yellow"));
        store.delete("10");
        Product result = store.findById("1");
        assertThat(result.getName(), is("Apple"));
    }
}