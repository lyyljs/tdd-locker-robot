package cn.xpbootcamp.gilded_rose.locker;

import cn.xpbootcamp.gilded_rose.bag.Bag;
import cn.xpbootcamp.gilded_rose.ticket.Ticket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LockerTest {

    private static final int LOCKER_SIZE = 19;

    @Test
    public void should_return_ticket_when_locker_available_given_bag() {
        Locker locker = new Locker(LOCKER_SIZE);
        Bag bag = new Bag();

        Ticket ticket = locker.save(bag);

        assertEquals(locker.getSize(), 18);
        assertNotNull(ticket);
    }
}
