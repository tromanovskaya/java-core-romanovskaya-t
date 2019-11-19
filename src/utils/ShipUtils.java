package utils;

import lesson3Object.Ship;
import lesson3Object.WorkDaysOfWeek;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class ShipUtils {

    private ShipUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Returns List<Ship> filtered for by field weight between weightMin and
     * weightMax.
     *
     * @param list      list objects Ship for filter
     * @param weightMax max value weight
     * @param weightMin min value weight
     * @return - new list after filter
     */
    public static List<Ship> filterShipListByWeight(List<Ship> list,
                                                    int weightMax,
                                                    int weightMin) {
        System.out.println("filterShipListByWeight ships: weightMax = " + weightMax + " weightMin = " + weightMin);
        List<Ship> ships = new ArrayList<>();
        for (Ship ship : list) {
            if ((ship.getWeight() >= weightMin) && (ship.getWeight() <= weightMax)) {
                ships.add(ship);
            }
        }
        return ships;
    }

    /**
     * Sort method Bubble for List<Ship> by field.
     *
     * @param list  list objects Ship for sort
     * @param field name get method for sort
     */
    public static void sortBubbleShipList(List<Ship> list, String field) {
        System.out.println("sortBubbleShipArray ships " + field);
        Ship temp;
        for (int i = 0; i < list.size(); i++) {
            for (int j = (list.size() - 1); j >= (i + 1); j--) {
                boolean condition;
                switch (field) {
                    case "getPrice":
                        condition =
                                list.get(j).getPrice() < list.get(j - 1).getPrice();
                        break;
                    case "getHumanSeats":
                        condition =
                                list.get(j).getHumanSeats() < list.get(j - 1).getHumanSeats();
                        break;
                    case "getWeight":
                        condition =
                                list.get(j).getWeight() < list.get(j - 1).getWeight();
                        break;
                    case "getName":
                        condition =
                                list.get(j - 1).getName().compareTo(list.get(j).getName()) > 0;
                        break;
                    case "getType":
                        condition =
                                list.get(j - 1).getType().compareTo(list.get(j).getType()) > 0;
                        break;
                    default:
                        condition = false;
                }
                if (condition) {
                    temp = list.get(j);
                    list.set(j, list.get(j - 1));
                    list.set(j - 1, temp);
                }
            }
        }
    }

    /**
     * Returns an array of Ship objects with random fields.
     *
     * @param countShip - number of objects
     * @return - array of objects Ship
     */
    public static List<Ship> generateShips(int countShip) {
        List<Ship> ships = new ArrayList<>();
        for (int i = 0; i < countShip; i++) {
            Ship ship = new Ship();
            ship.setName(RandomStringUtils.random(10, true, false));
            ship.setHumanSeats(parseInt(RandomStringUtils.randomNumeric(5)));
            ship.setPrice(parseInt(RandomStringUtils.randomNumeric(7)));
            ship.setType(RandomStringUtils.random(4, true, false));
            ship.setWeight(parseInt(RandomStringUtils.randomNumeric(4)));
            ship.setWorkDaysOfWeek(WorkDaysOfWeek.FIVE);
            ships.add(ship);
        }
        return ships;
    }

    /**
     * Print a List of Ship objects.
     *
     * @param ships - List of Ship objects
     */
    public static void printShips(List<Ship> ships) {
        for (Ship ship : ships) {
            System.out.println(ship);
        }
    }
}
