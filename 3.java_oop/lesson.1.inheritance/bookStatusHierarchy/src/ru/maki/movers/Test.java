package ru.maki.movers;

import ru.maki.Book;
import ru.maki.Status;

public class Test {
    public static void main() {
        Book book = new Book("The Lord of the Rings");
        BookMover fromAvailableStatusMover = new FromAvailableStatusMover();
        BookMover fromArchievedStatusMover = new FromArchievedStatusMover();
        BookMover fromOverduedStatusMover = new FromOverduedStatusMover();
        BookMover fromBorrowedStatusMover = new FromBorrowedStatusMover();
        //
        fromAvailableStatusMover.moveToStatus(book, Status.BORROWED);
        System.out.println(book.getStatus());
        fromBorrowedStatusMover.moveToStatus(book, Status.BORROWED);
        System.out.println(book.getStatus());
        fromBorrowedStatusMover.moveToStatus(book, Status.AVAILABLE);
        System.out.println(book.getStatus());
        fromAvailableStatusMover.moveToStatus(book, Status.BORROWED);
        System.out.println(book.getStatus());
        fromBorrowedStatusMover.moveToStatus(book, Status.ARCHIVED);
        System.out.println(book.getStatus());
        fromArchievedStatusMover.moveToStatus(book, Status.BORROWED);
        System.out.println(book.getStatus());
        fromArchievedStatusMover.moveToStatus(book, Status.OVERDUED);
        System.out.println(book.getStatus());
        fromArchievedStatusMover.moveToStatus(book, Status.AVAILABLE);
        System.out.println(book.getStatus());
        fromAvailableStatusMover.moveToStatus(book, Status.BORROWED);
        System.out.println(book.getStatus());
        fromBorrowedStatusMover.moveToStatus(book, Status.OVERDUED);
        System.out.println(book.getStatus());
        fromOverduedStatusMover.moveToStatus(book, Status.BORROWED);
        System.out.println(book.getStatus());
        fromOverduedStatusMover.moveToStatus(book, Status.AVAILABLE);
        System.out.println(book.getStatus());
    }
}
