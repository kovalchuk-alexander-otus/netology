package ru.maki.movers;

import ru.maki.Book;
import ru.maki.Status;

public class FromAvailableStatusMover extends BookMover {

    public void moveToStatus(Book book, Status requestedStatus) {
        super.moveToStatus(book, requestedStatus);

        switch (requestedStatus) {
            case ARCHIVED:
            case BORROWED:
                book.setStatus(requestedStatus);
                break;
            case OVERDUED:
            case AVAILABLE:
                System.out.printf("Перевод книги из статуса '%s' в статус '%s' невозможен\n", book.getStatus(), requestedStatus);
                break;
            default:
                System.out.printf("Статус %s не известный - возможно требуется доработка ПО\n", requestedStatus);
        }
    }
}
