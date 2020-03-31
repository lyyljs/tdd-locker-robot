package cn.xpbootcamp.gilded_rose.locker;

import cn.xpbootcamp.gilded_rose.bag.Bag;
import cn.xpbootcamp.gilded_rose.locker.exception.InvalidTicketException;
import cn.xpbootcamp.gilded_rose.locker.exception.LockerIsFullException;
import cn.xpbootcamp.gilded_rose.ticket.Ticket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LockerTest {

    private static final int LOCKER_SIZE = 19;

    @Test
    void should_return_ticket_when_locker_available_given_bag() {
        // given
        Locker locker = new Locker(LOCKER_SIZE);
        Bag bag = new Bag();

        // when
        Ticket ticket = locker.save(bag);

        // then
        assertNotNull(ticket);
    }

    @Test
    void should_throw_an_error_when_locker_is_full_given_a_bag() {
        // given
        Locker locker = new Locker(0);
        Bag bag = new Bag();

        // when & then
        assertThrows(LockerIsFullException.class, () -> locker.save(bag));
    }

    @Test
    void should_return_bag_when_get_bag_given_valid_ticket() {
        // given
        Locker locker = new Locker(LOCKER_SIZE);
        Bag bag = new Bag();
        Ticket ticket = locker.save(bag);

        // when
        Bag retrievedBag = locker.getBag(ticket);

        // then
        assertEquals(bag, retrievedBag);
    }

    @Test
    void should_throw_an_error_when_get_bag_given_an_invalid_ticket() {
        // given
        Locker locker = new Locker(LOCKER_SIZE);
        Ticket ticket = new Ticket();

        // when & then
        assertThrows(InvalidTicketException.class, () -> locker.getBag(ticket));
    }

    @Test
    void should_throw_invalid_ticket_exception_when_get_bag_given_an_duplicate_ticket() {
        // given
        Locker locker = new Locker(LOCKER_SIZE);
        Bag bag = new Bag();
        Ticket ticket = locker.save(bag);

        // when
        Bag retrievedBag = locker.getBag(ticket);

        // when & then
        assertThrows(InvalidTicketException.class, () -> locker.getBag(ticket));
    }
}
