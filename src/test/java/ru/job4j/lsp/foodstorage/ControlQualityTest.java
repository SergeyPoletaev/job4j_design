package ru.job4j.lsp.foodstorage;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class ControlQualityTest {

    @Test
    public void whenExpense20PercentThenRedistributeInWarehouse() {
        Calendar createDate = new GregorianCalendar(2022, Calendar.JANUARY, 10);
        Calendar expiryDate = new GregorianCalendar(2022, Calendar.JANUARY, 20);
        long currentTime = new GregorianCalendar(2022, Calendar.JANUARY, 12).getTimeInMillis();
        Store warehouse = new WareHouse();
        Store shop = new Shop();
        Store trash = new Trash();
        ControlQuality service = new ControlQuality(warehouse, shop, trash);
        service.setCurrentTime(currentTime);
        service.redistribute(new Food("milk", createDate, expiryDate, new BigDecimal(125), 10));
        assertThat(warehouse.findAll(), is(List.of(new Food("milk", createDate, expiryDate, new BigDecimal(125), 10))));
        assertTrue(shop.findAll().isEmpty());
        assertTrue(trash.findAll().isEmpty());
    }

    @Test
    public void whenExpense25PercentThenRedistributeInShop() {
        Calendar createDate = new GregorianCalendar(2022, Calendar.MARCH, 1);
        Calendar expiryDate = new GregorianCalendar(2022, Calendar.JUNE, 29);
        long currentTime = new GregorianCalendar(2022, Calendar.MARCH, 31).getTimeInMillis();
        Store warehouse = new WareHouse();
        Store shop = new Shop();
        Store trash = new Trash();
        ControlQuality service = new ControlQuality(warehouse, shop, trash);
        service.setCurrentTime(currentTime);
        service.redistribute(new Food("milk", createDate, expiryDate, new BigDecimal(125), 10));
        assertThat(shop.findAll(), is(List.of(new Food("milk", createDate, expiryDate, new BigDecimal(125), 10))));
        assertTrue(warehouse.findAll().isEmpty());
        assertTrue(trash.findAll().isEmpty());
    }

    @Test
    public void whenExpense50PercentThenRedistributeInShop() {
        Calendar createDate = new GregorianCalendar(2022, Calendar.JANUARY, 10);
        Calendar expiryDate = new GregorianCalendar(2022, Calendar.JANUARY, 20);
        long currentTime = new GregorianCalendar(2022, Calendar.JANUARY, 15).getTimeInMillis();
        Store warehouse = new WareHouse();
        Store shop = new Shop();
        Store trash = new Trash();
        ControlQuality service = new ControlQuality(warehouse, shop, trash);
        service.setCurrentTime(currentTime);
        service.redistribute(new Food("milk", createDate, expiryDate, new BigDecimal(125), 10));
        assertThat(shop.findAll(), is(List.of(new Food("milk", createDate, expiryDate, new BigDecimal(125), 10))));
        assertTrue(warehouse.findAll().isEmpty());
        assertTrue(trash.findAll().isEmpty());
    }

    @Test
    public void whenExpense75PercentThenRedistributeInShop() {
        Calendar createDate = new GregorianCalendar(2022, Calendar.MARCH, 1);
        Calendar expiryDate = new GregorianCalendar(2022, Calendar.APRIL, 10);
        long currentTime = new GregorianCalendar(2022, Calendar.MARCH, 31).getTimeInMillis();
        Store warehouse = new WareHouse();
        Store shop = new Shop();
        Store trash = new Trash();
        ControlQuality service = new ControlQuality(warehouse, shop, trash);
        service.setCurrentTime(currentTime);
        service.redistribute(new Food("milk", createDate, expiryDate, new BigDecimal(125), 10));
        assertThat(shop.findAll(), is(List.of(new Food("milk", createDate, expiryDate, new BigDecimal(125), 10))));
        assertTrue(warehouse.findAll().isEmpty());
        assertTrue(trash.findAll().isEmpty());
    }

    @Test
    public void whenExpense80PercentThenRedistributeInShopWithDiscount() {
        Calendar createDate = new GregorianCalendar(2022, Calendar.JANUARY, 10);
        Calendar expiryDate = new GregorianCalendar(2022, Calendar.JANUARY, 20);
        long currentTime = new GregorianCalendar(2022, Calendar.JANUARY, 18).getTimeInMillis();
        Store warehouse = new WareHouse();
        Store shop = new Shop();
        Store trash = new Trash();
        ControlQuality service = new ControlQuality(warehouse, shop, trash);
        service.setCurrentTime(currentTime);
        service.redistribute(new Food("milk", createDate, expiryDate, new BigDecimal(125), 10));
        assertThat(shop.findAll(), is(List.of(new Food("milk", createDate, expiryDate, new BigDecimal("112.5"), 10))));
        assertTrue(warehouse.findAll().isEmpty());
        assertTrue(trash.findAll().isEmpty());
    }

    @Test
    public void whenExpense100PercentThenRedistributeInTrash() {
        Calendar createDate = new GregorianCalendar(2022, Calendar.JANUARY, 10);
        Calendar expiryDate = new GregorianCalendar(2022, Calendar.JANUARY, 20);
        long currentTime = new GregorianCalendar(2022, Calendar.JANUARY, 20).getTimeInMillis();
        Store warehouse = new WareHouse();
        Store shop = new Shop();
        Store trash = new Trash();
        ControlQuality service = new ControlQuality(warehouse, shop, trash);
        service.setCurrentTime(currentTime);
        service.redistribute(new Food("milk", createDate, expiryDate, new BigDecimal(125), 10));
        assertThat(trash.findAll(), is(List.of(new Food("milk", createDate, expiryDate, new BigDecimal(125), 10))));
        assertTrue(warehouse.findAll().isEmpty());
        assertTrue(shop.findAll().isEmpty());
    }

    @Test
    public void whenExpense120PercentThenRedistributeInTrash() {
        Calendar createDate = new GregorianCalendar(2022, Calendar.JANUARY, 10);
        Calendar expiryDate = new GregorianCalendar(2022, Calendar.JANUARY, 20);
        long currentTime = new GregorianCalendar(2022, Calendar.JANUARY, 22).getTimeInMillis();
        Store warehouse = new WareHouse();
        Store shop = new Shop();
        Store trash = new Trash();
        ControlQuality service = new ControlQuality(warehouse, shop, trash);
        service.setCurrentTime(currentTime);
        service.redistribute(new Food("milk", createDate, expiryDate, new BigDecimal(125), 10));
        assertThat(trash.findAll(), is(List.of(new Food("milk", createDate, expiryDate, new BigDecimal(125), 10))));
        assertTrue(warehouse.findAll().isEmpty());
        assertTrue(shop.findAll().isEmpty());
    }
}