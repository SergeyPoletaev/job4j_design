package ru.job4j.lsp.foodstorage;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class ControlQualityTest {

    @Test
    public void whenExpense25PercentThenRedistributeInShop() {
        Calendar createDate = Calendar.getInstance();
        Calendar expiryDate = Calendar.getInstance();
        createDate.set(createDate.get(Calendar.YEAR), createDate.get(Calendar.MONTH), createDate.get(Calendar.DAY_OF_MONTH) - 30);
        expiryDate.set(expiryDate.get(Calendar.YEAR), expiryDate.get(Calendar.MONTH), expiryDate.get(Calendar.DAY_OF_MONTH) + 90);
        Store warehouse = new WareHouse();
        Store shop = new Shop();
        Store trash = new Trash();
        ControlQuality service = new ControlQuality(List.of(warehouse, shop, trash));
        Food milk = new Food("milk", createDate, expiryDate, new BigDecimal(125), 10);
        service.redistribute(milk);
        assertThat(shop.findAll(), is(List.of(milk)));
        assertTrue(warehouse.findAll().isEmpty());
        assertTrue(trash.findAll().isEmpty());
    }

    @Test
    public void whenExpense75PercentThenRedistributeInShop() {
        Calendar createDate = Calendar.getInstance();
        Calendar expiryDate = Calendar.getInstance();
        createDate.set(createDate.get(Calendar.YEAR), createDate.get(Calendar.MONTH), createDate.get(Calendar.DAY_OF_MONTH) - 30);
        expiryDate.set(expiryDate.get(Calendar.YEAR), expiryDate.get(Calendar.MONTH), expiryDate.get(Calendar.DAY_OF_MONTH) + 10);
        Store warehouse = new WareHouse();
        Store shop = new Shop();
        Store trash = new Trash();
        ControlQuality service = new ControlQuality(List.of(warehouse, shop, trash));
        Food milk = new Food("milk", createDate, expiryDate, new BigDecimal(125), 10);
        service.redistribute(milk);
        assertThat(shop.findAll(), is(List.of(milk)));
        assertTrue(warehouse.findAll().isEmpty());
        assertTrue(trash.findAll().isEmpty());
    }

    @Test
    public void whenExpense100PercentThenRedistributeInTrash() {
        Calendar createDate = Calendar.getInstance();
        Calendar expiryDate = Calendar.getInstance();
        createDate.set(createDate.get(Calendar.YEAR), createDate.get(Calendar.MONTH), createDate.get(Calendar.DAY_OF_MONTH) - 10);
        expiryDate.set(expiryDate.get(Calendar.YEAR), expiryDate.get(Calendar.MONTH), expiryDate.get(Calendar.DAY_OF_MONTH));
        Store warehouse = new WareHouse();
        Store shop = new Shop();
        Store trash = new Trash();
        ControlQuality service = new ControlQuality(List.of(warehouse, shop, trash));
        Food milk = new Food("milk", createDate, expiryDate, new BigDecimal(125), 10);
        service.redistribute(milk);
        assertThat(trash.findAll(), is(List.of(milk)));
        assertTrue(warehouse.findAll().isEmpty());
        assertTrue(shop.findAll().isEmpty());
    }

    @Test
    public void whenRedistributingMultipleProducts() {
        /* whenExpense20Percent */
        Calendar createDate = Calendar.getInstance();
        Calendar expiryDate = Calendar.getInstance();
        createDate.set(createDate.get(Calendar.YEAR), createDate.get(Calendar.MONTH), createDate.get(Calendar.DAY_OF_MONTH) - 2);
        expiryDate.set(expiryDate.get(Calendar.YEAR), expiryDate.get(Calendar.MONTH), expiryDate.get(Calendar.DAY_OF_MONTH) + 8);
        Food milk = new Food("milk", createDate, expiryDate, new BigDecimal(125), 10);
        /* whenExpense50Percent */
        Calendar createDate1 = Calendar.getInstance();
        Calendar expiryDate1 = Calendar.getInstance();
        createDate1.set(createDate1.get(Calendar.YEAR), createDate1.get(Calendar.MONTH), createDate1.get(Calendar.DAY_OF_MONTH) - 5);
        expiryDate1.set(expiryDate1.get(Calendar.YEAR), expiryDate1.get(Calendar.MONTH), expiryDate1.get(Calendar.DAY_OF_MONTH) + 5);
        Food bread = new Food("bread", createDate1, expiryDate1, new BigDecimal(125), 10);
        /* whenExpense80Percent */
        Calendar createDate2 = Calendar.getInstance();
        Calendar expiryDate2 = Calendar.getInstance();
        createDate2.set(createDate2.get(Calendar.YEAR), createDate2.get(Calendar.MONTH), createDate2.get(Calendar.DAY_OF_MONTH) - 8);
        expiryDate2.set(expiryDate2.get(Calendar.YEAR), expiryDate2.get(Calendar.MONTH), expiryDate2.get(Calendar.DAY_OF_MONTH) + 2);
        Food coffee = new Food("coffee", createDate2, expiryDate2, new BigDecimal(125), 10);
        Food coffeeWithDiscount = new Food("coffee", createDate2, expiryDate2, new BigDecimal("112.5"), 10);
        /* whenExpense120Percent */
        Calendar createDate3 = Calendar.getInstance();
        Calendar expiryDate3 = Calendar.getInstance();
        createDate3.set(createDate3.get(Calendar.YEAR), createDate3.get(Calendar.MONTH), createDate3.get(Calendar.DAY_OF_MONTH) - 12);
        expiryDate3.set(expiryDate3.get(Calendar.YEAR), expiryDate3.get(Calendar.MONTH), expiryDate3.get(Calendar.DAY_OF_MONTH) - 2);
        Food orange = new Food("orange", createDate3, expiryDate3, new BigDecimal(125), 10);

        Store warehouse = new WareHouse();
        Store shop = new Shop();
        Store trash = new Trash();
        ControlQuality service = new ControlQuality(List.of(warehouse, shop, trash));
        List<Food> foods = List.of(milk, bread, coffee, orange);
        foods.forEach(service::redistribute);
        assertThat(warehouse.findAll(), is(List.of(milk)));
        assertThat(shop.findAll(), is(List.of(bread, coffeeWithDiscount)));
        assertThat(trash.findAll(), is(List.of(orange)));
    }
}