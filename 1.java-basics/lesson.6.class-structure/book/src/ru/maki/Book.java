package ru.maki;

public class Book {

    final int BIG_BOOK_PAGES = 500;
    final int MIN_PRICE = 250;
    final int PAGE_PRICE = 3;

    final String title; // название книги
    final int releaseYear; // год выпуска
    final Author author; // автор
    final int pages; // количество страниц

    public Book(String title, int releaseYear, Author author, int pages) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.author = author;
        this.pages = pages;
    }

    // признак большой книги
    public boolean isBig() {
        return this.pages > BIG_BOOK_PAGES;
    }

    // поиск текста в описании книги (названии или в имени автора)
    public boolean matches(String word) {
        return this.title.contains(word) || this.author.name.contains(word) || this.author.surname.contains(word);
    }

    // оценочная стоимость книги (в рублях)
    public int estimatePrice() {
        return Math.max(MIN_PRICE, (int) Math.floor(this.pages * PAGE_PRICE * Math.sqrt(this.author.rating)));
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                '}';
    }
}
