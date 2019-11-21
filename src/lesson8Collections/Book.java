package lesson8Collections;

import java.util.Objects;

public class Book {
    private String name;
    private String authorSurName;
    private String authorFirstName;
    private String authorSecondName;

    public Book() {
    }

    public Book(String name, String authorSurName, String authorFirstName, String authorSecondName) {
        this.name = name;
        this.authorSurName = authorSurName;
        this.authorFirstName = authorFirstName;
        this.authorSecondName = authorSecondName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorSurName() {
        return authorSurName;
    }

    public void setAuthorSurName(String authorSurName) {
        this.authorSurName = authorSurName;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorSecondName() {
        return authorSecondName;
    }

    public void setAuthorSecondName(String authorSecondName) {
        this.authorSecondName = authorSecondName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) &&
                Objects.equals(authorSurName, book.authorSurName) &&
                Objects.equals(authorFirstName, book.authorFirstName) &&
                Objects.equals(authorSecondName, book.authorSecondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, authorSurName, authorFirstName, authorSecondName);
    }

    @Override
    public String toString() {
        return "Book{" +
                "authorSurName='" + authorSurName + '\'' +
                ", authorFirstName='" + authorFirstName + '\'' +
                ", authorSecondName='" + authorSecondName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
