package cn.xpbootcamp.gilded_rose.robot;

import cn.xpbootcamp.gilded_rose.bag.Bag;
import cn.xpbootcamp.gilded_rose.locker.Locker;
import cn.xpbootcamp.gilded_rose.locker.exception.InvalidTicketException;
import cn.xpbootcamp.gilded_rose.locker.exception.LockerIsFullException;
import cn.xpbootcamp.gilded_rose.ticket.Ticket;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RobotTest {
    private static final int DEFAULT_LOCKER_CAPACITY = 10;

    @Test
    void should_return_ticket_when_store_bag_given_locker_is_available() {
        // given
        Locker locker = new Locker(DEFAULT_LOCKER_CAPACITY);
        List<Locker> lockers = new ArrayList<>();
        lockers.add(locker);

        Robot robot = new Robot(lockers);
        Bag bag = new Bag();

        // when
        Ticket ticket = robot.storeBag(bag);

        // then
        assertNotNull(ticket);
    }

    @Test
    void should_return_ticket_when_store_bag_given_locker_1_full_and_locker_2_available() {
        // given
        Locker locker1 = new Locker(0);
        Locker locker2 = new Locker(DEFAULT_LOCKER_CAPACITY);

        Robot robot = new Robot(new ArrayList<Locker>() {{
            add(locker1);
            add(locker2);
        }});
        Bag bag = new Bag();

        // when
        Ticket ticket = robot.storeBag(bag);

        // then
        assertNotNull(ticket);
    }

    @Test
    void should_return_ticket_when_store_bag_given_all_lockers_are_available() {
        // given
        Locker locker1 = new Locker(DEFAULT_LOCKER_CAPACITY);
        Locker locker2 = new Locker(DEFAULT_LOCKER_CAPACITY);

        Robot robot = new Robot(new ArrayList<Locker>() {{
            add(locker1);
            add(locker2);
        }});
        Bag bag = new Bag();

        // when
        Ticket ticket = robot.storeBag(bag);

        // then
        assertEquals(locker1.retrieveBag(ticket), bag);
    }

    @Test
    void should_throw_locker_full_when_store_bag_given_all_lockers_full() {
        // given
        Locker locker1 = new Locker(0);
        Locker locker2 = new Locker(0);

        Robot robot = new Robot(new ArrayList<Locker>() {{
            add(locker1);
            add(locker2);
        }});
        Bag bag = new Bag();

        // when & then
        assertThrows(LockerIsFullException.class, () -> robot.storeBag(bag));
    }

    @Test
    void should_return_the_saved_bag_when_retrieve_bag_given_a_vaild_ticket() {
        // given
        Locker locker = new Locker(DEFAULT_LOCKER_CAPACITY);
        Bag bag = new Bag();
        Robot robot = new Robot(new ArrayList<Locker>() {{
            add(locker);
        }});

        Ticket ticket = robot.storeBag(bag);

        // when & then
        assertEquals(robot.retrieveBag(ticket), bag);
    }

    @Test
    void should_throw_invalid_ticket_exception_when_retrieve_bag_given_invalid_ticket() {
        // given
        Locker locker = new Locker(DEFAULT_LOCKER_CAPACITY);
        Robot robot = new Robot(new ArrayList<Locker>() {{
            add(locker);
        }});

        Ticket ticket = new Ticket();

        // when & then
        assertThrows(InvalidTicketException.class, () -> robot.retrieveBag(ticket));
    }

    @Test
    void should_throw_invaild_ticket_exception_when_retrieve_bag_twice_given_a_vaild_ticket() {
        // given
        Locker locker = new Locker(DEFAULT_LOCKER_CAPACITY);
        Bag bag = new Bag();
        Robot robot = new Robot(new ArrayList<Locker>() {{
            add(locker);
        }});

        Ticket ticket = robot.storeBag(bag);
        robot.retrieveBag(ticket);

        // when & then
        assertThrows(InvalidTicketException.class, () -> robot.retrieveBag(ticket));
    }
}
