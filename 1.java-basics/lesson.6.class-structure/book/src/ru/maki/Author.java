package ru.maki;

public class Author {

    final String name; // имя
    final String surname; // фамилия
    final int rating; // рейтинг, целое число

    public Author(String name, String surname, int rating) {
        this.name = name;
        this.surname = surname;
        this.rating = rating;
    }
}
