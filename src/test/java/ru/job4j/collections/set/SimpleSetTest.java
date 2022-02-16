package ru.job4j.collections.set;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SimpleSetTest {

    @Test
    public void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenSetNoElementsThenIterNexEx() {
        Set<Integer> set = new SimpleSet<>();
        Iterator<Integer> it = set.iterator();
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenAddElementThenIterNexEx() {
        Set<Integer> set = new SimpleSet<>();
        set.add(1);
        Iterator<Integer> it = set.iterator();
        it.next();
        set.add(2);
        it.next();
    }
}