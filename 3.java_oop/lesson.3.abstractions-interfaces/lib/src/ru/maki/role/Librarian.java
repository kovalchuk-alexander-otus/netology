package ru.maki.role;

import ru.maki.Book;
import ru.maki.File;

// Библиотекарь
public interface Librarian {

    // оформление заказа Книг(и)
    File[] makeOrder(Book[] books, File[] files);
}
