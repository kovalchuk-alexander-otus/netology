package ru.maki;

import ru.maki.staff.User;

import java.time.LocalDate;

public class File extends Book {

    int        hall;
    int        cabinet;
    int        shelf;
    LocalDate  returnDate;
    BookStatus bookStatus;
    User       user;


    public File(String name) {
        super(name);
    }

    // размещение книги на полке - регистрация в системе места расположения
    public void regBook(int hall, int cabinet, int shelf, LocalDate returnDate,
                        BookStatus bookStatus, User user) {
        this.hall       = hall;
        this.cabinet    = cabinet;
        this.shelf      = shelf;
        this.returnDate = returnDate;
        this.bookStatus = bookStatus;
        this.user       = user;
    }

    public void regBook(LocalDate returnDate) {
        this.returnDate = returnDate;

        this.bookStatus = BookStatus.PURCHASE;
    }

    public void regBook(LocalDate returnDate, User user) {
        this.returnDate = returnDate;
        this.user       = user;

        this.bookStatus = BookStatus.ON_HAND;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public int getHall() {
        return hall;
    }

    public int getCabinet() {
        return cabinet;
    }

    public int getShelf() {
        return shelf;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "File{" +
                "hall=" + hall +
                ", cabinet=" + cabinet +
                ", shelf=" + shelf +
                ", returnDate=" + returnDate +
                ", bookStatus=" + bookStatus +
                ", user=" + (user == null ? "" : user.getIO()) +
                '}';
    }
}
