package utils;

import lesson8Collections.Student;

import java.util.ArrayList;
import java.util.List;

import static utils.RandomUtils.RANDOM;

public class StudentUtils {

    private static List<String> surNames;
    private static List<String> firstNames;
    private static List<String> secondNames;
    private static List<String> groups;

    private StudentUtils() {
        throw new IllegalStateException("Utility class");
    }

    static {
        surNames = new ArrayList<>();
        surNames.add("Швед");
        surNames.add("Шеин");
        surNames.add("Романовская");
        surNames.add("Мигалевич");
        firstNames = new ArrayList<>();
        firstNames.add("Павел");
        firstNames.add("Анна");
        firstNames.add("Татьяна");
        firstNames.add("Ольга");
        secondNames = new ArrayList<>();
        secondNames.add("Олегович");
        secondNames.add("Витальевна");
        secondNames.add("Евгеньевна");
        groups = new ArrayList<>();
        groups.add("Группа1");
        groups.add("Группа2");
        groups.add("Группа3");
    }

    public static List<Student> generateRandomListStudent(int count) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            students.add(new Student(surNames.get(RANDOM.nextInt(surNames.size())),
                    firstNames.get(RANDOM.nextInt(firstNames.size())),
                    secondNames.get(RANDOM.nextInt(secondNames.size())),
                    groups.get(RANDOM.nextInt(groups.size()))));
        }
        return students;
    }

}
