package cn.xpbootcamp.gilded_rose.robot;

import cn.xpbootcamp.gilded_rose.bag.Bag;
import cn.xpbootcamp.gilded_rose.locker.Locker;
import cn.xpbootcamp.gilded_rose.ticket.Ticket;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperRobotTest {
    private static final int DEFAULT_LOCKER_CAPACITY = 10;

    @Test
    void should_return_ticket_and_store_into_locker_2_when_store_bag_given_locker_1_vacancy_rate_is_less_than_locker_2() {
        // given
        Locker locker1 = new Locker(DEFAULT_LOCKER_CAPACITY);
        Locker locker2 = new Locker(DEFAULT_LOCKER_CAPACITY - 1);
        locker1.storeBag(new Bag());

        SuperRobot robot = new SuperRobot(new ArrayList<Locker>() {{
            add(locker1);
            add(locker2);
        }});
        Bag bag = new Bag();

        // when
        Ticket ticket = robot.storeBag(bag);

        //then
        assertEquals(locker2.retrieveBag(ticket), bag);
    }
}
