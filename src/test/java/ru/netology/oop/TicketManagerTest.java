package ru.netology.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {

    Ticket ticket1 = new Ticket("Москва", "Петербург", 1200, 12, 15); // время 3
    Ticket ticket2 = new Ticket("Москва", "Сочи", 4500, 18, 21);
    Ticket ticket3 = new Ticket("Москва", "Владивосток", 13000, 6, 15);
    Ticket ticket4 = new Ticket("Москва", "Петербург", 1100, 15, 16); // время 1
    Ticket ticket5 = new Ticket("Калуга", "Воронеж", 1500, 11, 12);
    Ticket ticket6 = new Ticket("Петербург", "Москва", 1200, 16, 18);
    Ticket ticket7 = new Ticket("Москва", "Петербург", 1500, 0, 2);   // время 2
    Ticket ticket8 = new Ticket("Тула", "Калуга", 1100, 22, 23);
    Ticket ticket9 = new Ticket("Москва", "Петербург", 1200, 15, 16); // время 1

    @Test
    public void shouldSearchAndSortByPriceAscendingIfTicketsExist() {
        TicketManager manager = new TicketManager();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        Ticket[] expected = {ticket4, ticket1, ticket9, ticket7};
        Ticket[] actual = manager.search("Москва", "Петербург");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotSearchIfNoTickets() {
        TicketManager manager = new TicketManager();
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket5);
        manager.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("Москва", "Петербург");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchIfOneTicket() {
        TicketManager manager = new TicketManager();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        Ticket[] expected = {ticket5};
        Ticket[] actual = manager.search("Калуга", "Воронеж");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchAndSortByPriceAscendingIfTicketsExistUsingComparator() {
        TicketTimeComparator comparator = new TicketTimeComparator();
        TicketManager manager = new TicketManager();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        Ticket[] expected = {ticket4, ticket9, ticket7, ticket1};
        Ticket[] actual = manager.searchAndSortBy("Москва", "Петербург", comparator);

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotSearchIfNoTicketsUsingComparator() {
        TicketTimeComparator comparator = new TicketTimeComparator();
        TicketManager manager = new TicketManager();
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket5);
        manager.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = manager.searchAndSortBy("Москва", "Петербург", comparator);

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchIfOneTicketUsingComparator() {
        TicketTimeComparator comparator = new TicketTimeComparator();
        TicketManager manager = new TicketManager();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        Ticket[] expected = {ticket5};
        Ticket[] actual = manager.searchAndSortBy("Калуга", "Воронеж", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
