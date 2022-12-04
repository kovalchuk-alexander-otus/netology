package ru.maki.staff;

import ru.maki.Book;
import ru.maki.File;
import ru.maki.role.Administrator;
import ru.maki.role.Librarian;
import ru.maki.role.Role;

import java.time.LocalDate;
import java.util.Arrays;

import static ru.maki.BookStatus.ON_HAND;

public class SmallLibraryWorker extends ReaderImpl implements Librarian, Administrator {

    public SmallLibraryWorker(String surname, String name, String patronymic,
                              LocalDate dateOfBirth) {
        super(surname, name, patronymic, dateOfBirth, Role.LIBRARIAN);
    }

    // находит книги
    @Override
    public void searchBook(String name, File[] files) {
        for (File file : files) {
            if (file.getName().equals(name)) {
                switch (file.getBookStatus()) {
                    case PURCHASE:
                        System.out.printf("Книга \"%s\" еще не поступила в " +
                                                  "Библиотеку%n%n", name);
                        break;
                    case ON_HAND:
                        System.out.printf("Книга \"%s\" сейчас на руках - надо немного " +
                                                  "подождать%n%n", name);
                        break;
                    case IN_STOCK:
                        System.out.printf("Книгу \"%s\" поищите в %d зале, %d шкаф, %d " +
                                                  "полка%n%n", name,
                                          file.getHall(),
                                          file.getCabinet(),
                                          file.getShelf());
                        break;
                    default:
                        break;
                }

                return;
            }
        }
        System.out.printf("Должна вас расстроить, но, книги \"%s\" у нас пока нет - но " +
                                  "мы можем заказать ее доставку..%n%n", name);
    }

    // выдает книги
    @Override
    public void giveBook(ReaderImpl reader, String name, File[] files) {
        System.out.printf("%s попыталась оформить выдачу книги \"%s\" %s%n", this.getIO(),
                          name, reader.getIO());
        reader.takeBook(name, files);
        System.out.printf("..и напомнил(а), что теперь у %s на руках:%n", reader.getIO());
        reader.showBooks();
    }

    // уведомляет о просрочках времени возврата
    @Override
    public void lateNotice(ReaderImpl reader, File[] files) {
        for (File file : files) {
            if (file.getBookStatus() == ON_HAND) {
                if (file.getUser().equals(reader))
                    System.out.printf("%s просьба вернуть книгу \"%s\"%n",
                                      file.getUser().getIO(), file.getName());
            }
        }
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
