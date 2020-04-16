package cn.xpbootcamp.gilded_rose.robot;

import cn.xpbootcamp.gilded_rose.bag.Bag;
import cn.xpbootcamp.gilded_rose.locker.Locker;
import cn.xpbootcamp.gilded_rose.locker.exception.LockerIsFullException;
import cn.xpbootcamp.gilded_rose.ticket.Ticket;

import java.util.Comparator;
import java.util.List;

public class SuperRobot extends Robot {
    public SuperRobot(List<Locker> lockers) { super(lockers); }

    @Override
    public Ticket storeBag(Bag bag) {
        return lockers.stream()
                .filter(locker -> !locker.isFull())
                .max(Comparator.comparingDouble(Locker::vacancyRate))
                .orElseThrow(LockerIsFullException::new)
                .storeBag(bag);

    }
}
