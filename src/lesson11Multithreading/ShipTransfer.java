package lesson11Multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;

public class ShipTransfer implements Callable<Cargo> {
    private int id;
    private Cargo cargo;
    private CountDownLatch countDownLatch;
    private ConcurrentLinkedQueue<ShipTransfer> queueShip;
    private ConcurrentLinkedQueue<Berth> queueBerth;

    public ShipTransfer() {
    }

    public ShipTransfer(int id, Cargo cargo, CountDownLatch countDownLatch, ConcurrentLinkedQueue<ShipTransfer> queueShip, ConcurrentLinkedQueue<Berth> queueBerth) {
        this.id = id;
        this.cargo = cargo;
        this.countDownLatch = countDownLatch;
        this.queueShip = queueShip;
        this.queueBerth = queueBerth;
    }

    @Override
    public Cargo call() {

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return new Cargo("error1:" + e.getMessage());
        }
        System.out.println("Ship " + id + " started. " + cargo);

        // go through the queue
        queueShip.add(this);

        System.out.println("Ship " + id + " in queueShip. size = " + queueShip.size());

        while (true) {
            // check if we are first in line
            if (queueShip.peek() == this) {
                Berth b = queueBerth.peek();
                assert b != null;
                if (b.occupiedPlaces.get() < 2) {

                    b.BARRIER.getParties();

                    // came to the first free berth (where there is at least 1 free berth)
                    // take a berth
                    b.occupiedPlaces.incrementAndGet();
                    // waiting for the next

                    // if all places (2) are occupied, move the berth to the end of the queue
                    if (b.occupiedPlaces.get() == 2) {
                        queueBerth.poll();
                        queueBerth.offer(b);
                    }

                    System.out.println("Ship " + id + " -----> Berth " + b.getId()
                            + " Places = " + b.occupiedPlaces.get());

                    queueShip.poll();// exit the queue
                    // waiting for the 2nd to exchange
                    try {
                        b.BARRIER.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                        return new Cargo("error2:" + e.getMessage());
                    }

                    try {
                        cargo = b.EXCHANGER.exchange(cargo);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return new Cargo("error3:" + e.getMessage());
                    }

                    // free up berth
                    b.occupiedPlaces.decrementAndGet();

                    // write on the ship in which berth exchanged
                    cargo.setBerth(b.getId());
                    System.out.println("Waited and exchanged Ship " + id + " end. " + cargo);

                    break;
                }
            } else {
                // let others take up processor time
                Thread.yield();
            }
        }

        return cargo;
    }
}
