package lesson5Abstract;

import lesson3Object.Ship;
import utils.ShipUtils;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        System.out.println("lesson5Abstract");
        List<Ship> ships = ShipUtils.generateShips(10);
        int i = 1;

        ShipUtils.printShips(ships);

        for (Ship ship : ships) {
            System.out.println("ship" + i + " = " + ship);
            System.out.print("ship.run() ----> ");
            ship.run();
            System.out.println("ship.generateSellPrice() ----> " + ship.generateSellPrice());
            i++;
        }
    }
}

