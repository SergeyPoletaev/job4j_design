package ru.job4j.ocp.smell;

/**
 * Этот класс содержить логику оплаты за покупки. Все методы класса служат одной цели - оплата,
 * то есть соблюден принцип SRP. Далее могут добавляться другие способы оплаты и для этого нам придется добавлять
 * другие методы в уже существующий, работающий и протестированный класс и тогда принцип ОСР , будет нарушен.
 * Лучше сразу выделить интерфейс Payments а в имплементирующих его классах реализовать метод pay().
 * Тогда при расширении уже рабочие классы либо вообще не будут затронуты, либо затронуты по минимуму.
 */
public class Payments {

    public void payWithCard() {
        System.out.println("Оплачено банковской картой картой");
    }

    public void payViaBank() {
        System.out.println("Оплачено через банк");
    }

    public void payInCash() {
        System.out.println("Оплачено наличными");
    }
}
