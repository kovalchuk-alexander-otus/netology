package ru.maki.role;

import ru.maki.Book;
import ru.maki.File;
import ru.maki.staff.User;

// Поставщик книг
public interface Supplier {

    // доставка Книг(и)
    void delieverOrder(User user, Book[] books, File[] files);
}
