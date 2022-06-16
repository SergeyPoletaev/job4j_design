package ru.job4j.tdd;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;


public class Cinema3DTest {

    @Ignore
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

    @Ignore
    @Test
    public void whenNotFound() {
        Cinema cinema = new Cinema3D();
        List<Session> sessions = cinema.find(s -> true);
        assertThat(sessions, is(empty()));
    }

    @Ignore
    @Test
    public void whenBuy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2022, Calendar.JUNE, 15, 15, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenBuyTicketWithInvalidSeat() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2022, Calendar.JUNE, 15, 15, 0);
        cinema.buy(account, -1, 1, date);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenBuyTicketWithInvalidDate() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(1977, Calendar.JUNE, 15, 15, 0);
        cinema.buy(account, 1, 1, date);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenBuyTicketWithOccupiedSeat() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2022, Calendar.JUNE, 15, 15, 0);
        cinema.buy(account, 1, 1, date);
        cinema.buy(account, 1, 1, date);
    }
}