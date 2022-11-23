package ru.maki.role;

import ru.maki.Book;
import ru.maki.File;
import ru.maki.staff.User;

// Библиотекарь
@SuppressWarnings("unused")
public interface Librarian {

    // оформление заказа Книг(и)
    File[] makeOrder(User user, Book[] books, File[] files);
}
