package ru.maki.role;

import ru.maki.Book;
import ru.maki.File;
import ru.maki.staff.User;

// Поставщик книг
@SuppressWarnings("unused")
public interface Supplier {

    // доставка Книг(и)
    void deliveryOrder(User user, Book[] books, File[] files);
}
