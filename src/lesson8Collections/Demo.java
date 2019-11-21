package lesson8Collections;

import utils.CollectionUtils;
import utils.MapUtils;

import java.util.*;

import static utils.BookUtils.generateRandomListBook;
import static utils.RandomUtils.RANDOM;
import static utils.StringUtils.isVowelRU;
import static utils.StudentUtils.generateRandomListStudent;

public class Demo {
    public static void main(String[] args) {
        runTaskWithBook();
        runTaskWithStudent();
        runTask5();
    }

    private static void runTaskWithBook() {
        // Task1
        System.out.println("1. Создать экземпляр класса LinkedList, разместить в " +
                "нём 3 ссылки на объекты класса Book. " +
                "List< Book > list = new LinkedList< Book >();\n" +
                "Вывести информацию о всех книгах.");
        List<Book> books = new LinkedList<>(generateRandomListBook(3));
        CollectionUtils.printList(books);
        System.out.println("\nПрограммно удалить из коллекции вторую книгу, вывести на экран информацию о оставшихся книгах.");
        int numberBookForDel = 2;
        books.remove(numberBookForDel - 1);
        CollectionUtils.printList(books);

        // Task2
        System.out.println("\n2. Создать экземпляр класса HashSet, добавить в него " +
                "25 ссылок на экземпляры класса Book, предусмотреть не менее 6 " +
                "одинаковых по значению книг.");


        System.out.println("Initial list:");
        books = new LinkedList<>(generateRandomListBook(6));
        books.addAll(books);// add duplicate
        books.addAll(generateRandomListBook(13));
        CollectionUtils.printList(books);

        System.out.println("HashSet:");
        Set<Book> bookHashSet = new HashSet<>();
        bookHashSet.addAll(books);
        CollectionUtils.printList(bookHashSet);

        System.out.println("\nВывести на экран информацию о книгах (содержащихся в " +
                "коллекции HashSet), название которых начинается с гласной буквы.");
        CollectionUtils.printList(getListBookWithStartNameVowelChar(bookHashSet));

        // Task3
        System.out.println("\n3. Отсортировать коллекцию из задания 2 по фамилии, " +
                "затем по имени, по отчеству (эти поля надо добавить в класс Book " +
                "для автора книги).");
        CollectionUtils.printList(sortCollection(bookHashSet));
    }

    private static List<Book> getListBookWithStartNameVowelChar(Set<Book> books) {
        List<Book> list = new ArrayList<>();
        for (Book book : books) {
            if (isVowelRU(book.getName().charAt(0))) {
                list.add(book);
            }
        }
        return list;
    }

    private static Set<Book> sortCollection(Set<Book> booksSet) {
        Set<Book> bookTreeSet = new TreeSet<>(Comparator.comparing(Book::getAuthorSurName)
                .thenComparing(Book::getAuthorFirstName)
                .thenComparing(Book::getAuthorSecondName)
                .thenComparing(Book::getName));
        bookTreeSet.addAll(booksSet);
        System.out.println("sort getAuthorSurName -> getAuthorFirstName -> getAuthorSecondName");
        return bookTreeSet;

    }

    private static void runTaskWithStudent() {
        System.out.println("\n4. Создать экземпляр класса TreeSet, поместить в " +
                "него объекты класса Student(надо его спроектировать).");

        List<Student> students = new ArrayList<>(generateRandomListStudent(10));
        sortWithComparable(students);
        sortWithStudentComparator(students);
        sortWithStudentComparatorComparing(students);

        System.out.println("\nВывести на экран информацию о каждом чётном в списке " +
                "студенте, каждого нечётного студента удалить из коллекции.");
        removeOddStudent(students);
        CollectionUtils.printList(students);

    }

    private static void sortWithComparable(List<Student> students) {
        //option 1
        System.out.println("option 1 with Student comparable");
        Set<Student> treeSet = new TreeSet<>();
        treeSet.addAll(students);
        CollectionUtils.printList(treeSet);
    }

    private static void sortWithStudentComparator(List<Student> students) {
        //option 2
        System.out.println("option 2 with StudentComparator");
        Set<Student> treeSet2 = new TreeSet<>(new StudentComparator());
        treeSet2.addAll(students);
        CollectionUtils.printList(treeSet2);
    }

    private static void sortWithStudentComparatorComparing(List<Student> students) {
        //option 3
        System.out.println("option 3 with Comparator.comparing");
        Set<Student> treeSet3 = new TreeSet<>(Comparator.comparing(Student::getFirstName)
                .thenComparing(Student::getSecondName)
                .thenComparing(Student::getGroup)
                .thenComparing(Student::getSurName));
        treeSet3.addAll(students);
        CollectionUtils.printList(treeSet3);
    }

    private static void removeOddStudent(List<Student> students) {
        Iterator<Student> iterator = students.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            i++;
            if (i % 2 == 1) {
                iterator.next();
                iterator.remove();
            } else {
                iterator.next();
            }
        }
    }

    private static Map<String, Integer> generateRandomMapCatalog(int count) {
        Map<String, Integer> map = new HashMap<>();
        List<String> keys = new ArrayList<>();
        keys.add("Гаджеты");
        keys.add("Аудиотехника");
        keys.add("Телеведение и видео");
        keys.add("Видеоигры");
        for (int i = 0; i < count; i++) {
            map.put(keys.get(RANDOM.nextInt(keys.size())), RANDOM.nextInt(5000));
        }
        return map;
    }

    private static void runTask5() {
        System.out.println("\n4. Создать экземпляр класса HashMap, разместить в нём " +
                "следующую информацию: в качестве ключа  - категория товара в каталоге " +
                "(catalog.onliner.by) в качестве значения - количество товаров в данной " +
                "категории.");

        Map<String, Integer> hashMap = new HashMap<>(generateRandomMapCatalog(10));
        hashMap.put("Комплектующие", 0);
        hashMap.put("Электропитание", 0);
        System.out.println("----------------");
        MapUtils.print(hashMap);
        System.out.println("----------------");

        System.out.println("\nСортировать коллекцию по количеству товаров в каждой " +
                "категории");
        Map<String, Integer> treeMap = sortByValue(hashMap);

        System.out.println("\nНайти категорию в которой содержится максимальное " +
                "количество товаров.");
        findKeyWithMaxValue(treeMap);

        System.out.println("\nУдалить все категории в которых нет ни одного товара " +
                "(предусмотреть такие категории при заполнении коллекции).");
        deleteElementWithValue(treeMap, 0);

    }

    private static Map<String, Integer> sortByValue(Map<String, Integer> goodsHashMap) {
        Map<String, Integer> mapSortValue = MapUtils.sortByValues(goodsHashMap);
        System.out.println("----------------");
        MapUtils.print(mapSortValue);
        System.out.println("----------------");
        return mapSortValue;
    }

    private static void findKeyWithMaxValue(Map<String, Integer> map) {
        Integer maxValue = 0;
        String keyForMaxValue = "";
        for (Map.Entry e : map.entrySet()) {
            if ((Integer) e.getValue() > maxValue) {
                keyForMaxValue = (String) e.getKey();
            }
        }
        System.out.println(keyForMaxValue + " " + map.get(keyForMaxValue));

    }

    private static void deleteElementWithValue(Map<String, Integer> goodsTreeMap, int valueForDelete) {
        Set keys = goodsTreeMap.keySet();
        for (Iterator i = keys.iterator(); i.hasNext(); ) {
            String key = (String) i.next();
            Integer value = (Integer) goodsTreeMap.get(key);
            if (value == valueForDelete) {
                i.remove();
            }
        }
        System.out.println("----------------");
        MapUtils.print(goodsTreeMap);
        System.out.println("----------------");
    }
}
