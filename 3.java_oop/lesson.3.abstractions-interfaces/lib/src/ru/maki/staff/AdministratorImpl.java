package ru.maki.staff;

import ru.maki.File;
import ru.maki.role.Role;

import java.time.LocalDate;

import static ru.maki.BookStatus.ON_HAND;

public class AdministratorImpl extends ReaderImpl implements ru.maki.role.Administrator {

    public AdministratorImpl(String surname, String name, String patronymic,
                             LocalDate dateOfBirth) {
        super(surname, name, patronymic, dateOfBirth, Role.ADMINISTRATOR);
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
}
