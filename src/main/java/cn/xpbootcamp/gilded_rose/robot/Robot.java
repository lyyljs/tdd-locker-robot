package cn.xpbootcamp.gilded_rose.robot;

import cn.xpbootcamp.gilded_rose.bag.Bag;
import cn.xpbootcamp.gilded_rose.locker.Locker;
import cn.xpbootcamp.gilded_rose.ticket.Ticket;

import java.util.List;

public class Robot {
    public Robot(List<Locker> lockers) {
    }

    public Ticket save(Bag bag) {
        return new Ticket();
    }
}
