package ru.job4j.collections;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleLinkedListTest {

    @Test
    public void whenAddAndGet() {
        List<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        assertThat(list.get(0), is(1));
        assertThat(list.get(1), is(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetFromOutOfBoundThenExceptionThrown() {
        List<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.get(2);
    }

    @Test
    public void whenAddIterHasNextTrue() {
        List<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), is(true));
    }

    @Test
    public void whenAddIterNextOne() {
        List<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        Iterator<Integer> it = list.iterator();
        assertThat(it.next(), is(1));
    }

    @Test
    public void whenEmptyIterHashNextFalse() {
        List<Integer> list = new SimpleLinkedList<>();
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenAddIterMultiHasNextTrue() {
        List<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
    }

    @Test
    public void whenAddIterNextOneNextTwo() {
        List<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        Iterator<Integer> it = list.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
    }

    @Test
    public void whenGetIteratorTwiceThenEveryFromBegin() {
        List<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        Iterator<Integer> first = list.iterator();
        assertThat(first.hasNext(), is(true));
        assertThat(first.next(), is(1));
        assertThat(first.hasNext(), is(true));
        assertThat(first.next(), is(2));
        assertThat(first.hasNext(), is(false));
        Iterator<Integer> second = list.iterator();
        assertThat(second.hasNext(), is(true));
        assertThat(second.next(), is(1));
        assertThat(second.hasNext(), is(true));
        assertThat(second.next(), is(2));
        assertThat(second.hasNext(), is(false));
    }
}