package cn.xpbootcamp.gilded_rose.locker;

import cn.xpbootcamp.gilded_rose.bag.Bag;
import cn.xpbootcamp.gilded_rose.ticket.Ticket;

public class Locker {

    private int size;

    public Locker(int size) {
        this.size = size;
    }

    public Ticket save(Bag bag) {
        this.size -= 1;
        return new Ticket();
    }

    public int getSize() {
        return size;
    }
}
