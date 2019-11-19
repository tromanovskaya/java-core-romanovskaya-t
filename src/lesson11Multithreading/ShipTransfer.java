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

        // проходим через очередь
        queueShip.add(this);

        System.out.println("Ship " + id + " in queueShip. size = " + queueShip.size());

        while (true) {
            // проверяем первые ли мы в очереди
            if (queueShip.peek() == this) {
                Berth b = queueBerth.peek();
                assert b != null;
                if (b.occupiedPlaces.get() < 2) {

                    b.BARRIER.getParties();

                    // пришли в первый свободный причал (где есть хотя бы 1 место свободное)
                    // занимаем место в причале
                    b.occupiedPlaces.incrementAndGet();
                    // ждем некст

                    // если все места(2) заняты перемещаем причал в конец очереди
                    if (b.occupiedPlaces.get() == 2) {
                        queueBerth.poll();
                        queueBerth.offer(b);
                    }

                    System.out.println("Ship " + id + " -----> Berth " + b.getId()
                            + " Places = " + b.occupiedPlaces.get());

                    queueShip.poll();// выходим из очереди
                    // ждем 2-ого для обмена
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

                    // освобождаем место
                    b.occupiedPlaces.decrementAndGet();

                    // запишем на посылке, в каком причале обменялись
                    cargo.setBerth(b.getId());
                    System.out.println("Дождались и обменялись Ship " + id + " end. " + cargo);

                    break;
                }
            } else {
                // пусть другие пока займут процессорное время
                Thread.yield();
            }
        }

        return cargo;
    }
}
