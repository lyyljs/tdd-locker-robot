package cn.xpbootcamp.gilded_rose.locker;

import cn.xpbootcamp.gilded_rose.bag.Bag;
import cn.xpbootcamp.gilded_rose.locker.exception.InvalidTicketException;
import cn.xpbootcamp.gilded_rose.locker.exception.LockerIsFullException;
import cn.xpbootcamp.gilded_rose.ticket.Ticket;

import java.util.HashMap;
import java.util.Map;

public class Locker {

    private int size;
    private final Map<Ticket, Bag> container = new HashMap<>();

    public Locker(int size) {
        this.size = size;
    }

    public Ticket save(Bag bag) {
        if (size == 0) {
            throw new LockerIsFullException();
        }

        size -= 1;
        Ticket ticket = new Ticket();
        container.put(ticket, bag);
        return ticket;
    }

    public int getSize() {
        return size;
    }

    public Bag getBag(Ticket ticket) {
        if (!container.containsKey(ticket)) {
            throw new InvalidTicketException();
        }

        size += 1;
        return container.get(ticket);
    }
}
