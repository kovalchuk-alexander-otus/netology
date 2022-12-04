package ru.maki.staff;

import ru.maki.Book;
import ru.maki.File;
import ru.maki.role.Role;

import java.time.LocalDate;
import java.util.Arrays;

public class LibrarianImpl extends ReaderImpl implements ru.maki.role.Librarian {
    public LibrarianImpl(String surname, String name, String patronymic,
                         LocalDate dateOfBirth) {
        super(surname, name, patronymic, dateOfBirth, Role.LIBRARIAN);
    }

    // оформление заказа Книг(и)
    @Override
    public File[] makeOrder(User user, Book[] books, File[] files) {
        System.out.printf("%s оформила доставку %s %d книг%n", this.getIO(),
                          user.getIO(), books.length);
        File[] newFile = Arrays.copyOf(files, files.length + books.length);
        int    id      = 0;
        for (int i = files.length; i < newFile.length; i++) {
            newFile[i] = new File(books[id++].getName());
            newFile[i].regBook(LocalDate.now());
            System.out.printf("Книга \"%s\" оформлена в заказе %s%n",
                              newFile[i].getName(), newFile[i].toString());
        }
        System.out.println("\n\n");
        return newFile;
    }
}
