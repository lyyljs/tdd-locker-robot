package cn.xpbootcamp.gilded_rose.robot;

import cn.xpbootcamp.gilded_rose.bag.Bag;
import cn.xpbootcamp.gilded_rose.locker.Locker;
import cn.xpbootcamp.gilded_rose.locker.exception.InvalidTicketException;
import cn.xpbootcamp.gilded_rose.locker.exception.LockerIsFullException;
import cn.xpbootcamp.gilded_rose.ticket.Ticket;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SmartRobotTest {

    private static final int DEFAULT_LOCKER_CAPACITY = 10;

    @Test
    void should_return_ticket_and_store_in_locker_2_when_store_given_locker_1_rest_capacity_less_than_locker_2() {
        // given
        Locker locker1 = new Locker(DEFAULT_LOCKER_CAPACITY - 1);
        Locker locker2 = new Locker(DEFAULT_LOCKER_CAPACITY);

        SmartRobot robot = new SmartRobot(new ArrayList<Locker>() {{
            add(locker1);
            add(locker2);
        }});
        Bag bag = new Bag();

        // when
        Ticket ticket = robot.storeBag(bag);

        // then
        assertEquals(locker2.retrieveBag(ticket), bag);
    }

    @Test
    void should_return_ticket_and_store_into_locker_1_when_store_given_locker_1_rest_capacity_greater_than_locker_2() {
        // given
        Locker locker1 = new Locker(DEFAULT_LOCKER_CAPACITY);
        Locker locker2 = new Locker(DEFAULT_LOCKER_CAPACITY - 1);

        SmartRobot robot = new SmartRobot(new ArrayList<Locker>() {{
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
    void should_return_ticket_and_store_into_locker_1_when_store_given_locker_1_rest_capacity_equal_to_locker_2() {
        // given
        Locker locker1 = new Locker(DEFAULT_LOCKER_CAPACITY);
        Locker locker2 = new Locker(DEFAULT_LOCKER_CAPACITY);

        SmartRobot robot = new SmartRobot(new ArrayList<Locker>() {{
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
    void should_throw_a_locker_full_exception_when_store_given_all_lockers_are_full() {
        // given
        Locker locker1 = new Locker(0);
        Locker locker2 = new Locker(0);

        SmartRobot robot = new SmartRobot(new ArrayList<Locker>() {{
            add(locker1);
            add(locker2);
        }});
        Bag bag = new Bag();

        // when & then
        assertThrows(LockerIsFullException.class, () -> robot.storeBag(bag));
    }

    @Test
    void should_return_the_saved_bag_when_retrieve_bag_given_a_valid_ticket() {
        // given
        Locker locker = new Locker(DEFAULT_LOCKER_CAPACITY);
        Bag bag = new Bag();
        SmartRobot smartRobot = new SmartRobot(new ArrayList<Locker>() {{
            add(locker);
        }});

        Ticket ticket = smartRobot.storeBag(bag);

        // when & then
        assertEquals(smartRobot.retrieveBag(ticket), bag);
    }

    @Test
    void should_throw_invalid_ticket_exception_when_retrieve_bag_given_invalid_ticket() {
        // given
        Locker locker = new Locker(DEFAULT_LOCKER_CAPACITY);
        SmartRobot smartRobot = new SmartRobot(new ArrayList<Locker>() {{
            add(locker);
        }});

        Ticket ticket = new Ticket();

        // when & then
        assertThrows(InvalidTicketException.class, () -> smartRobot.retrieveBag(ticket));
    }

    @Test
    void should_throw_invalid_ticket_exception_when_retrieve_bag_twice_given_a_valid_ticket() {
        // given
        Locker locker = new Locker(DEFAULT_LOCKER_CAPACITY);
        Bag bag = new Bag();
        SmartRobot smartRobot = new SmartRobot(new ArrayList<Locker>() {{
            add(locker);
        }});

        Ticket ticket = smartRobot.storeBag(bag);
        smartRobot.retrieveBag(ticket);

        // when & then
        assertThrows(InvalidTicketException.class, () -> smartRobot.retrieveBag(ticket));
    }
}
