package cn.xpbootcamp.gilded_rose.robot;

import cn.xpbootcamp.gilded_rose.bag.Bag;
import cn.xpbootcamp.gilded_rose.locker.Locker;
import cn.xpbootcamp.gilded_rose.locker.exception.InvalidTicketException;
import cn.xpbootcamp.gilded_rose.locker.exception.LockerIsFullException;
import cn.xpbootcamp.gilded_rose.ticket.Ticket;

import java.util.List;

public class Robot {
    private List<Locker> lockers;

    public Robot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket storeBag(Bag bag) {
        return lockers.stream()
                .filter(locker -> !locker.isFull())
                .findFirst()
                .orElseThrow(LockerIsFullException::new)
                .storeBag(bag);
    }

    public Bag retrieveBag(Ticket ticket) {
        return lockers.stream()
                .filter(locker -> locker.isStoredBag(ticket))
                .findFirst()
                .orElseThrow(InvalidTicketException::new)
                .retrieveBag(ticket);
    }
}
