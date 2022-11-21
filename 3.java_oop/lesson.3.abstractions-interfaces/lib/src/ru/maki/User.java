package ru.maki;

import ru.maki.role.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

import static ru.maki.BookStatus.ON_HAND;

public class User implements Reader, Librarian, Supplier, Administrator {

    String    Surname;
    String    Name;
    String    Patronymic;
    LocalDate dateOfBirth;
    File[]    files;
    Role      role;
    Random random = new Random();

    public User(String surname, String name, String patronymic, LocalDate dateOfBirth,
                Role role) {
        this.Surname     = surname;
        this.Name        = name;
        this.Patronymic  = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.role        = role;
        this.files       = new File[0];
    }

    @Override
    public void takeBook(String name, File[] files) {
        File[] newFiles = Arrays.copyOf(this.files, this.files.length+1);
        for (File file : files) {
            if (file.getName().equals(name)) {
                switch(file.getBookStatus()){
                    case IN_STOCK:
                        file.regBook(LocalDate.now(),this);
                        newFiles[this.files.length] = file;
                        this.files = newFiles;
                        System.out.printf("Наслаждайтесь чтением \"%s\"%n%n", name);
                        break;
                    case PURCHASE:
                        System.out.printf("Книга \"%s\" еще не поступила в " +
                                                  "Библиотеку%n%n", name);
                        break;
                    case ON_HAND:
                        System.out.printf("Книга \"%s\" сейчас на руках - надо немного " +
                                                  "подождать%n%n", name);
                        break;
                    default: break;
                }
            }
        }
    }

    @Override
    public void returnBook(int idx, File[] files) {
        if (this.files.length == 0) {
            System.out.println("У вас нет книг к возврату");
            return;
        }
        if (this.files.length < idx) {
            System.out.println("Укажите корректный номер книги к возврату:");
            this.showBooks();
            return;
        }
        File[] newFiles = new File[this.files.length - 1];
        int    id       = 0;
        for (int i = 0; i < this.files.length; i++) {
            if (i != idx - 1) newFiles[id++] = this.files[i];
            else
                files[i].regBook(random.nextInt(10), random.nextInt(20),
                             random.nextInt(8), LocalDate.now(), BookStatus.IN_STOCK,
                                 null);
        }
        this.files = newFiles;
    }

    public void showBooks() {
        for (int i = 0; i < this.files.length; i++) {
            System.out.printf("%d) %s%n", i + 1, this.files[i].getName());
        }
        System.out.println("\n\n");
    }

    public String getIO() {
        return String.valueOf(new StringBuilder(this.Name).append(" ").append(this.Patronymic));
    }

    @Override
    public File[] makeOrder(Book[] books, File[] files) {
        File[] newFile = Arrays.copyOf(files, files.length + books.length);
        int    id      = 0;
        for (int i = files.length; i < newFile.length; i++) {
            newFile[i] = new File(books[id++].getName());
            newFile[i].regBook(LocalDate.now());
            System.out.printf("Книга оформлена в заказе %s%n", newFile[i].toString());
        }
        System.out.println("\n\n");
        return newFile;
    }

    @Override
    public void delieverOrder(Book[] books, File[] files) {
        for (Book book : books) {
            for (File file : files) {
                if (book.getName() == file.getName()) {
                    file.regBook(random.nextInt(10), random.nextInt(20),
                                 random.nextInt(8), LocalDate.now(),
                                 BookStatus.IN_STOCK, null);
                    System.out.printf("Книга зарегистрирована %s%n", file.toString());
                    break;
                }
            }
        }
        System.out.println("\n\n");
    }

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

    @Override
    public void giveBook(File file, File[] files) {

    }

    @Override
    public void lateNotice(File[] files) {
        for (File file : files) {
            if (file.getBookStatus() == ON_HAND) {
                System.out.printf("%s просьба вернуть книгу \"%s\"%n",
                                  file.getUser().getIO(), file.getName());
            }
        }
    }
}
