package cn.xpbootcamp.gilded_rose.locker;

import cn.xpbootcamp.gilded_rose.bag.Bag;
import cn.xpbootcamp.gilded_rose.locker.exception.InvalidTicketException;
import cn.xpbootcamp.gilded_rose.locker.exception.LockerIsFullException;
import cn.xpbootcamp.gilded_rose.ticket.Ticket;

import java.util.HashMap;
import java.util.Map;

public class Locker {

    private int capacity;
    private final Map<Ticket, Bag> storedBags = new HashMap<>();

    public Locker(int capacity) {
        this.capacity = capacity;
    }

    public Ticket storeBag(Bag bag) {
        if (isFull()) {
            throw new LockerIsFullException();
        }

        Ticket ticket = new Ticket();
        storedBags.put(ticket, bag);
        return ticket;
    }

    public Bag retrieveBag(Ticket ticket) {
        if (!storedBags.containsKey(ticket)) {
            throw new InvalidTicketException();
        }

        return storedBags.remove(ticket);
    }

    public boolean isFull() {
        return capacity <= storedBags.size();
    }

    public int availableCapacity() {
        return capacity - storedBags.size();
    }

    public boolean isStoredBag(Ticket ticket) {
        return storedBags.containsKey(ticket);
    }

    public double vacancyRate() {
        return availableCapacity() / (double)capacity;
    }
}
