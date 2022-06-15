package ru.job4j.tdd;

import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;


public class Cinema3DTest {

    @Test
    public void whenFind() {
        Cinema cinema = new Cinema3D();
        Session sessionFirst = new Session3D();
        Session sessionSecond = new Session3D();
        cinema.add(sessionFirst);
        cinema.add(sessionSecond);
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(s -> true);
        assertThat(sessions, is(List.of(sessionFirst, sessionSecond)));
    }

    @Test
    public void whenNotFound() {
        Cinema cinema = new Cinema3D();
        List<Session> sessions = cinema.find(s -> true);
        assertThat(sessions, is(empty()));
    }

    @Test
    public void whenBuy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2022, Calendar.JUNE, 15, 15, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }
}