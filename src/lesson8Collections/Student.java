package lesson8Collections;

import java.util.Objects;

public class Student implements Comparable {
    private String SurName;
    private String FirstName;
    private String SecondName;
    private String Group;

    public Student() {
    }

    public Student(String surName, String firstName, String secondName, String group) {
        SurName = surName;
        FirstName = firstName;
        SecondName = secondName;
        Group = group;
    }

    public String getSurName() {
        return SurName;
    }

    public void setSurName(String surName) {
        SurName = surName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }

    public String getGroup() {
        return Group;
    }

    public void setGroup(String group) {
        Group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(SurName, student.SurName) &&
                Objects.equals(FirstName, student.FirstName) &&
                Objects.equals(SecondName, student.SecondName) &&
                Objects.equals(Group, student.Group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(SurName, FirstName, SecondName, Group);
    }

    @Override
    public String toString() {
        return "Student{" +
                "SurName='" + SurName + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", SecondName='" + SecondName + '\'' +
                ", Group='" + Group + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Student st = (Student) o;
        int value = this.toString().compareTo(st.toString());
        if (value == 0) {
            return this.toString().compareTo(st.toString());
        } else {
            return value;
        }
    }
}
