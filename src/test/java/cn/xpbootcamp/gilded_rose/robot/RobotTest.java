package cn.xpbootcamp.gilded_rose.robot;

import cn.xpbootcamp.gilded_rose.bag.Bag;
import cn.xpbootcamp.gilded_rose.locker.Locker;
import cn.xpbootcamp.gilded_rose.ticket.Ticket;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RobotTest {
    private static final int DEFAULT_LOCKER_CAPACITY = 10;

    @Test
    void should_return_ticket_when_save_bag_given_locker_is_available() {
        // given
        Locker locker = new Locker(DEFAULT_LOCKER_CAPACITY);
        List<Locker> lockers = new ArrayList<>();
        lockers.add(locker);

        Robot robot = new Robot(lockers);
        Bag bag = new Bag();

        // when
        Ticket ticket = robot.save(bag);

        // then
        assertNotNull(ticket);
    }
}
