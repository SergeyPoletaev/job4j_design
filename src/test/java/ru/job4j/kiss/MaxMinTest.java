package ru.job4j.kiss;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MaxMinTest {

    @Test
    public void whenMaxFirst() {
        var words = List.of("sveta", "anna", "nik");
        var comp = Comparator.comparing(String::length, Integer::compareTo);
        assertThat(new MaxMin().max(words, comp), is("sveta"));
    }

    @Test
    public void whenMaxLast() {
        var words = List.of("anna", "nik", "sveta");
        var comp = Comparator.comparing(String::length, Integer::compareTo);
        assertThat(new MaxMin().max(words, comp), is("sveta"));
    }

    @Test
    public void whenMaxMiddle() {
        var words = List.of("anna", "sveta", "nik");
        var comp = Comparator.comparing(String::length, Integer::compareTo);
        assertThat(new MaxMin().max(words, comp), is("sveta"));
    }

    @Test
    public void whenMinFirst() {
        var words = List.of("nik", "sveta", "anna");
        var comp = Comparator.comparing(String::length, Integer::compareTo);
        assertThat(new MaxMin().min(words, comp), is("nik"));
    }

    @Test
    public void whenMinLast() {
        var words = List.of("anna", "sveta", "nik");
        var comp = Comparator.comparing(String::length, Integer::compareTo);
        assertThat(new MaxMin().min(words, comp), is("nik"));
    }

    @Test
    public void whenMinMiddle() {
        var words = List.of("sveta", "nik", "anna");
        var comp = Comparator.comparing(String::length, Integer::compareTo);
        assertThat(new MaxMin().min(words, comp), is("nik"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenEmptyListThenEx() {
        var words = new ArrayList<String>();
        var comp = Comparator.comparing(String::length, Integer::compareTo);
        new MaxMin().max(words, comp);
    }
}