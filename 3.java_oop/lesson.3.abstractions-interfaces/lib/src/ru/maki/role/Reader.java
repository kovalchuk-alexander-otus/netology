package ru.maki.role;

import ru.maki.Book;
import ru.maki.File;
import ru.maki.staff.User;

// Читатель
public interface Reader {

    // беру книгу в Библиотеке
    void takeBook(String name, File[] files);

    // возвращаю книгу в Библиотеку
    void returnBook(User user, int idx, File[] files);
}
