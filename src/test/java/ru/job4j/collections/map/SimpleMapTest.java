package ru.job4j.collections.map;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleMapTest {

    @Test
    public void whenUniqKeyPutThenTrue() {
        Map<String, Integer> map = new SimpleMap<>();
        assertTrue(map.put("anna", 12));
    }

    @Test
    public void whenDuplicateKeyPutThenFalse() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("anna", 12);
        assertFalse(map.put("anna", 24));
    }

    @Test
    public void put() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("nik", 10);
        map.put("anna", 12);
        assertThat(map.get("anna"), is(12));
    }

    @Test
    public void whenKeyIsAbsentThenGetReturnNull() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("petr", 14);
        assertNull(map.get("anna"));
    }

    @Test
    public void get() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("anna", 14);
        assertThat(map.get("anna"), is(14));
    }

    @Test
    public void remove() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("anna", 12);
        map.remove("anna");
        assertNull(map.get("anna"));
    }

    @Test
    public void whenRslRemovePositiveThenTrue() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("anna", 12);
        assertTrue(map.remove("anna"));
    }

    @Test
    public void whenRslNegativeThenFalse() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("anna", 12);
        assertFalse(map.remove("nik"));
    }

    @Test
    public void whenIteratorNextNextThenKeyKey() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("anna", 12);
        map.put("nik", 10);
        Iterator<String> it = map.iterator();
        assertNotNull(it.next());
        assertNotNull(it.next());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNextIsAbsentThenEx() {
        Map<String, Integer> map = new SimpleMap<>();
        map.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenModifiedPutThenNextEx() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("anna", 12);
        map.put("peter", 14);
        Iterator<String> it = map.iterator();
        it.next();
        map.put("nik", 10);
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenModifiedRemoveThenNextEx() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("anna", 12);
        map.put("peter", 14);
        map.put("nik", 10);
        Iterator<String> it = map.iterator();
        it.next();
        map.remove("nik");
        it.next();
    }
}