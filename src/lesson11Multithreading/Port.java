package lesson11Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static utils.FileUtils.rnd;

public class Port {

    public static void main(String[] args) {
        System.out.println("Тема Корабли. \n" +
                "Имеется заданное число кораблей и заданной число причалов, где корабли должны обмениваться грузами. \n" +
                "Необходимо организовать эмуляцию работы порта, \n" +
                "т.е. обмен грузами между кораблями. Один причал вмещает 2 корабля. \n" +
                "Корабли, для которых причала не нашлось должны быть помещены в очередь для ожидания. \n" +
                "А для кого нашлась должны провести обмен грузами. \n" +
                "Каждое действие должно быть записано и выведено на консоль. \n" +
                "Порт должен принять все корабли и завершить свою работу.");


        int numberOfShips = 100;// кол.-во кораблей
        int numberOfBerth = 9;// кол.-во причалов
        // очередь для причалов
        ConcurrentLinkedQueue<Berth> queueBerth = new ConcurrentLinkedQueue<>();
        // очередь для кораблей
        ConcurrentLinkedQueue<ShipTransfer> queueShip = new ConcurrentLinkedQueue<>();

        try {
            System.out.println("---- Запуск работы причалов ----");
            startBerths(numberOfBerth, queueBerth);

            List<Future<Cargo>> futureList = startShips(numberOfShips, queueShip, queueBerth);

            int i = 0;
            for (Future<Cargo> future : futureList) {
                System.out.println("--future " + i + " " + future.get().toString());
                i++;
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void startBerths(int numberOfBerth, ConcurrentLinkedQueue<Berth> queueBerth) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < numberOfBerth; i++) {
            Berth berth = new Berth(i, queueBerth);
            service.execute(berth);
        }
        service.shutdown();
        service.awaitTermination(1, TimeUnit.SECONDS); // Даем еще время на завршение потоков
    }

    private static List<Future<Cargo>> startShips(int numberOfShips, ConcurrentLinkedQueue<ShipTransfer> queueShip, ConcurrentLinkedQueue<Berth> queueBerth) throws InterruptedException {
        List<Future<Cargo>> futureList = new ArrayList<>();
        CountDownLatch countDownLatch = new CountDownLatch(1);

        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int i = 0; i < numberOfShips; i++) {
            Cargo cargo = null;
            if (i % 2 == 0) {
                cargo = new Cargo(i, "bananas", rnd.nextInt(10000));
            } else if (i % 3 == 0) {
                cargo = new Cargo(i, "oranges", rnd.nextInt(1000));
            } else {
                cargo = new Cargo(i, "watermelons", rnd.nextInt(100));
            }
            ShipTransfer shipTransfer = new ShipTransfer(i, cargo, countDownLatch, queueShip, queueBerth);
            Future<Cargo> future = service.submit(shipTransfer);
            futureList.add(future);
        }

        service.shutdown();

        // старт одновременно
        System.out.println("---- Старт всех кораблей одновременно ----");
        countDownLatch.countDown();

        service.awaitTermination(2, TimeUnit.SECONDS); // Даем еще время на завршение потоков

        return futureList;
    }


}
