package lesson3Object;

import org.apache.commons.lang3.RandomStringUtils;
import utils.ShipUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.util.Comparator.comparing;

public class Demo {
    public static void main(String[] args) {
        List<Ship> ships = new ArrayList<>();
        List<Ship> newShips;
        int weightMax = 1500;
        int weightMin = 10;

        for (int i = 0; i < 10; i++) {
            Ship ship = new Ship();
            ship.setName(RandomStringUtils.random(10, true, false));
            ship.setHumanSeats(parseInt(RandomStringUtils.randomNumeric(5)));
            ship.setPrice(parseInt(RandomStringUtils.randomNumeric(7)));
            ship.setType(RandomStringUtils.random(4, true, false));
            ship.setWeight(parseInt(RandomStringUtils.randomNumeric(4)));
            ships.add(ship);
        }

        for (Ship ship : ships) {
            System.out.println(ship.toString());
        }

        System.out.println("\nCollections.sort ships getPrice ");
        Collections.sort(ships, comparing(Ship::getPrice));

        for (Ship ship : ships) {
            System.out.println(ship.toString());
        }

        System.out.println("");
        ShipUtils.sortBubbleShipList(ships, "getName");

        for (Ship ship : ships) {
            System.out.println(ship.toString());
        }

        System.out.println("");
        newShips = ShipUtils.filterShipListByWeight(ships, weightMax, weightMin);
        for (Ship ship : newShips) {
            System.out.println(ship.toString());
        }
    }
}
