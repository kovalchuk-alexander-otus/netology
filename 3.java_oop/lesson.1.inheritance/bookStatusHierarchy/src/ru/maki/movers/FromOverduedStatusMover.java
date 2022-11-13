package ru.maki.movers;

import ru.maki.Book;
import ru.maki.Status;

public class FromOverduedStatusMover extends BookMover {

    public void moveToStatus(Book book, Status requestedStatus) {
        super.moveToStatus(book, requestedStatus);

        switch (requestedStatus) {
            case ARCHIVED:
            case AVAILABLE:
                book.setStatus(requestedStatus);
                break;
            case OVERDUED:
            case BORROWED:
                System.out.printf("Перевод книги из статуса '%s' в статус '%s' невозможен\n", book.getStatus(), requestedStatus);
                break;
            default:
                System.out.printf("Статус %s не известный - возможно требуется доработка ПО\n", requestedStatus);
        }
    }
}
