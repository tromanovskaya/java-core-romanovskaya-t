package lesson8Collections;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

    public int compare(Student o1, Student o2) {
        // Assume no nulls, and simple ordinal comparisons

        // First
        int groupResult = o1.getGroup().compareTo(o2.getGroup());
        if (groupResult != 0) {
            return groupResult;
        }

        // Next
        int surNameResult = o1.getSurName().compareTo(o2.getSurName());
        if (surNameResult != 0) {
            return surNameResult;
        }

        // Next
        int firstNameResult = o1.getFirstName().compareTo(o2.getFirstName());
        if (firstNameResult != 0) {
            return firstNameResult;
        }

        // Finally by building
        return o1.getSecondName().compareTo(o2.getSecondName());
    }

}
