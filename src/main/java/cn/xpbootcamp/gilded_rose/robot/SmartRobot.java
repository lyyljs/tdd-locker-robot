package cn.xpbootcamp.gilded_rose.robot;

import cn.xpbootcamp.gilded_rose.bag.Bag;
import cn.xpbootcamp.gilded_rose.locker.Locker;
import cn.xpbootcamp.gilded_rose.locker.exception.LockerIsFullException;
import cn.xpbootcamp.gilded_rose.ticket.Ticket;

import java.util.Comparator;
import java.util.List;

public class SmartRobot extends Robot {
    public SmartRobot(List<Locker> lockers) {
        super(lockers);
    }

    @Override
    public Ticket storeBag(Bag bag) {
        return lockers.stream()
                .filter(locker -> !locker.isFull())
                .max(Comparator.comparingInt(Locker::availableCapacity))
                .orElseThrow(LockerIsFullException::new)
                .storeBag(bag);
    }
}
