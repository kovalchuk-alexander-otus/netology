package ru.maki.movers;

import ru.maki.Book;
import ru.maki.Status;

import static ru.maki.Status.AVAILABLE;

public class FromArchievedStatusMover extends BookMover{

    public void moveToStatus(Book book, Status requestedStatus) {
        super.moveToStatus(book, requestedStatus);

        if (requestedStatus == AVAILABLE) book.setStatus(AVAILABLE);
        else System.out.printf("Перевод книги из статуса '%s' в статус '%s' невозможен\n",book.getStatus(), requestedStatus);
    }
}
