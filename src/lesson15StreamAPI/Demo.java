package lesson15StreamAPI;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        int countPerson = 5;

        List<Person> people = createPeople(countPerson);
        System.out.println(people);
        RunTask1(people);
        RunTask2(people);
        RunTask3(people);
    }

    private static List<Person> createPeople(int cnt) {
        List<Person> people = new ArrayList<>();
        int maxAge = 100;

        for (int i = 0; i <= cnt; i++) {
            int age = RandomUtils.RANDOM.nextInt(maxAge);
            String name;
            switch (i) {
                case 0:
                    name = "Паша";
                    break;
                case 1:
                    name = "Оля";
                    break;
                case 2:
                    name = "Аня";
                    break;
                case 3:
                    name = "Таня";
                    break;
                case 4:
                    name = "Максим";
                    break;
                default:
                    name = "Славик";
            }

            people.add(new Person(name, age));
        }
        return people;
    }

    private static void RunTask1(List<Person> people) {
        System.out.println("--- 1) в возрасте старше 20 лет");
        Predicate<Person> personPredicate = person -> person.getAge() > 20;
        List<Person> peopleNew = people
                .stream()
                .filter(personPredicate)
                //.peek(System.out::println)
                .collect(Collectors.toList());
        System.out.println(peopleNew);
    }

    private static void RunTask2(List<Person> people) {
        System.out.println("--- 2) посчитать средний возраст всех людей с именами, начинающимися на гласную букву");
        Predicate<Person> personPredicate2 = person -> person.getName()
                .substring(0, 1)
                .toLowerCase()
                .replaceAll("[^аеыоэяию]", "")
                .length() == 1;
        double sumAge = people
                .stream()
                .filter(personPredicate2)
                .mapToInt(Person::getAge)
                .average()
                .orElse(0);
        System.out.println("sumAge = " + sumAge);
    }

    private static void RunTask3(List<Person> people) {
        System.out.println("--- 3) отфильтровать и вывести уникальные объекты в взрасте превышающий средний возраст всех людей");

        double averageAge = people
                .stream().mapToInt(Person::getAge)
                .average()
                .orElse(0);
        System.out.println("averageAge = " + averageAge);

        List<Person> peopleNew = people.stream()
                .filter(person -> (double) person.getAge() > averageAge)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(peopleNew);
    }
}
