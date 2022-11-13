package ru.maki.movers;

import ru.maki.Book;
import ru.maki.Status;

public class BookMover {
    protected void moveToStatus(Book book, Status requestedStatus) {
        if (book.getStatus() == requestedStatus) System.out.println("Книга изначально в требуемом статусе");
        else System.out.println("Moving status...");
    }
}
