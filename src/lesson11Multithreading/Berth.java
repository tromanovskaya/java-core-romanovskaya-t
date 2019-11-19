package lesson11Multithreading;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;
import java.util.concurrent.atomic.AtomicInteger;

public class Berth implements Runnable {
    private int id;
    public Exchanger<Cargo> EXCHANGER = new Exchanger<>();
    public CyclicBarrier BARRIER = new CyclicBarrier(2);
    private ConcurrentLinkedQueue<Berth> queueBerth;
    public AtomicInteger occupiedPlaces = new AtomicInteger(0);

    public Berth() {
    }

    public Berth(int id, ConcurrentLinkedQueue<Berth> queueBerth) {
        this.id = id;
        this.queueBerth = queueBerth;
    }

    public int getId() {
        return id;
    }

    @Override
    public void run() {
        System.out.println(" Berth " + id + " готов!");
        queueBerth.add(this);
        System.out.println(" Berth " + id + " in queueBerth!");
    }
}
