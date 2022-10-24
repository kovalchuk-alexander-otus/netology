package ru.maki;

import ru.maki.enums.Genre;
import ru.maki.enums.Lang;

public class Book {

    private final int LENGTH_INTRODUCTORY_FRAGMENT = 7; // размер ознакомительного фрагмента
    private Author author; // Автор произведения
    private String name; // Название произведения
    private Lang lang; // Язык (ENUM)
    private Genre genre; // Жанр (ENUM)
    private int countOfPage; // Количество страниц
    private int yearOfPublishing; // Год издания
    private String text; // Текст
    private double price; // Стоимость

    public Book(Author author, String name, Lang lang, Genre genre, int countOfPage, int yearOfPublishing, double price) {
        this.author = author;
        this.name = name;
        this.lang = lang;
        this.genre = genre;
        this.countOfPage = countOfPage;
        this.yearOfPublishing = yearOfPublishing;
        this.text = "";
        this.price = price;
        System.out.println(this.name + " complete");
    }

    // loadText - загрузка текста произведения
    public void loadText(String text) {
        this.text = text;
        System.out.println("complete");
    }

    // readBook - чтение книги on-line
    public void readBook(boolean introductoryFragment) {
        System.out.println(introductoryFragment ? this.text.substring(0, LENGTH_INTRODUCTORY_FRAGMENT) : this.text);
    }

    //searchText - поиск фрагмента текста в книге
    public int searchText(String textToFind) {
        int result = this.text.indexOf(textToFind);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", lang='" + lang + '\'' +
                ", genre='" + genre + '\'' +
                ", countOfPage=" + countOfPage +
                ", yearOfPublishing=" + yearOfPublishing +
                ", text='" + text + '\'' +
                ", price=" + String.format("%.2f", price) + '}';
    }
}
