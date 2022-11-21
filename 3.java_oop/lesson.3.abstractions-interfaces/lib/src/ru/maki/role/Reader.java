package ru.maki.role;

import ru.maki.Book;
import ru.maki.File;

// Читатель
public interface Reader {

    // беру книгу в Библиотеке
    void takeBook(String name, File[] files);

    // возвращаю книгу в Библиотеку
    void returnBook(int idx, File[] files);
}
