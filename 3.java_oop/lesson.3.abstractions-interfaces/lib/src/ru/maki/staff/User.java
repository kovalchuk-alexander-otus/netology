package ru.maki.staff;

import ru.maki.BookStatus;
import ru.maki.File;
import ru.maki.role.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

public class User implements Reader {

    static int       sequence = 0;
    final  int       idx;
    final  String    Surname;
    final  String    Name;
    final  String    Patronymic;
    final  LocalDate dateOfBirth;
    File[]    files;
    final Role   role;
    final Random random = new Random();

    public User(String surname, String name, String patronymic, LocalDate dateOfBirth,
                Role role) {
        this.Surname     = surname;
        this.Name        = name;
        this.Patronymic  = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.role        = (role == null) ? Role.READER : role;
        this.files       = new File[0];
        User.sequence++;
        this.idx = User.sequence; // какой-то id пользака заведем ... на случай поиска
    }
    public User(String surname, String name, String patronymic, LocalDate dateOfBirth) {
        this(surname, name, patronymic, dateOfBirth, Role.READER);
    }

    // взять книгу
    @Override
    public void takeBook(String name, File[] files) {
        File[] newFiles = Arrays.copyOf(this.files, this.files.length + 1);
        for (File file : files) {
            if (file.getName().equals(name)) {
                switch (file.getBookStatus()) {
                    case IN_STOCK:
                        file.regBook(LocalDate.now(), this);
                        newFiles[this.files.length] = file;
                        this.files = newFiles;
                        System.out.printf("Наслаждайтесь чтением \"%s\"%n", name);
                        break;
                    case PURCHASE:
                        System.out.printf("Книга \"%s\" еще не поступила в " +
                                                  "Библиотеку%n", name);
                        break;
                    case ON_HAND:
                        System.out.printf("Книга \"%s\" сейчас на руках - надо немного " +
                                                  "подождать%n", name);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    // вернуть книгу
    @Override
    public void returnBook(User user, int idx, File[] files) {
        if (this.files.length == 0) {
            System.out.printf("%s, у вас нет книг к возврату%n", this.getIO());
            return;
        }
        if (this.files.length < idx) {
            System.out.printf("%s, укажите корректный номер книги к возврату:%n",
                              this.getIO());
            this.showBooks();
            return;
        }
        File[] newFiles = new File[this.files.length - 1];
        int    id       = 0;

        for (int i = 0; i < this.files.length; i++) {
            if (i != idx - 1) newFiles[id++] = this.files[i];
            else {
                System.out.printf("%s возвращает до дыр зачитанный талмуд \"%s\" %s%n",
                                  this.getIO(), this.files[i].getName(), user.getIO());
                this.files[i].regBook(random.nextInt(10), random.nextInt(20),
                                 random.nextInt(8), LocalDate.now(), BookStatus.IN_STOCK,
                                 null);}
        }
        this.files = newFiles;
    }

    // перечень книг, которые на руках у читателя
    public void showBooks() {
        for (int i = 0; i < this.files.length; i++) {
            System.out.printf("%d) %s%n", i + 1, this.files[i].getName());
        }
        System.out.println("\n\n");
    }

    // ИО - имя отчество пользователя
    public String getIO() {
        return this.Name + " " + this.Patronymic;
    }

    @Override
    public String toString() {
        return "User{" +
                "idx=" + idx +
                ", Surname='" + Surname + '\'' +
                ", Name='" + Name + '\'' +
                ", Patronymic='" + Patronymic + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", files=" + Arrays.toString(files) +
                ", role=" + role +
                ", random=" + random +
                '}';
    }
}
