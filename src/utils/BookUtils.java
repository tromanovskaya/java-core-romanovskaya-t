package utils;

import lesson8Collections.Book;

import java.util.ArrayList;
import java.util.List;

import static utils.RandomUtils.RANDOM;

public class BookUtils {

    private static List<String> names;
    private static List<String> authorSurNames;
    private static List<String> authorFirstNames;
    private static List<String> authorSecondNames;

    private BookUtils() {
        throw new IllegalStateException("Utility class");
    }

    static {
        names = new ArrayList<>();
        names.add("Война и мир");
        names.add("Лолита");
        names.add("Унесённые ветром");
        names.add("Анна Каренина");
        names.add("Преступление и наказание");
        names.add("Идиот");
        names.add("Мёртвые души");
        names.add("Отцы и дети");
        authorSurNames = new ArrayList<>();
        authorSurNames.add("Толстой");
        authorSurNames.add("Набоков");
        authorSurNames.add("Митчелл");
        authorSurNames.add("Достоевский");
        authorSurNames.add("Гоголь");
        authorSurNames.add("Тургенев");
        authorFirstNames = new ArrayList<>();
        authorFirstNames.add("Лев");
        authorFirstNames.add("Владимир");
        authorFirstNames.add("Маргарет");
        authorFirstNames.add("Федор");
        authorFirstNames.add("Николай");
        authorFirstNames.add("Иван");
        authorSecondNames = new ArrayList<>();
        authorSecondNames.add("Николаевич");
        authorSecondNames.add("Владимирович");
        authorSecondNames.add("Манерлин");
        authorSecondNames.add("Михайлович");
        authorSecondNames.add("Васильевич");
        authorSecondNames.add("Сергеевич");
    }

    public static List<Book> generateRandomListBook(int count) {
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            books.add(new Book(names.get(RANDOM.nextInt(names.size())),
                    authorSurNames.get(RANDOM.nextInt(authorSurNames.size())),
                    authorFirstNames.get(RANDOM.nextInt(authorFirstNames.size())),
                    authorSecondNames.get(RANDOM.nextInt(authorSecondNames.size()))));

        }
        return books;
    }
}
