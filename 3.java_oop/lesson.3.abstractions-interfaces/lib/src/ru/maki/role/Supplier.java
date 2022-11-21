package ru.maki.role;

import ru.maki.Book;
import ru.maki.File;

// Поставщик книг
public interface Supplier {

    // доставка Книг(и)
    void delieverOrder(Book[] books, File[] files);
}
