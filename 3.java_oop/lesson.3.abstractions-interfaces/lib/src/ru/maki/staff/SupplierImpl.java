package ru.maki.staff;

import ru.maki.Book;
import ru.maki.BookStatus;
import ru.maki.File;
import ru.maki.role.Role;

import java.time.LocalDate;

public class SupplierImpl extends ReaderImpl implements ru.maki.role.Supplier {
    public SupplierImpl(String surname, String name, String patronymic,
                        LocalDate dateOfBirth) {
        super(surname, name, patronymic, dateOfBirth, Role.SUPPLIER);
    }
    @Override
    public void deliveryOrder(User user, Book[] books, File[] files) {
        System.out.printf("%s передал %s следующие фолианты:%n", this.getIO(),
                          user.getIO());
        for (Book book : books) {
            for (File file : files) {
                if (book.getName().equals(file.getName())) {
                    file.regBook(random.nextInt(10), random.nextInt(20),
                                 random.nextInt(8), LocalDate.now(),
                                 BookStatus.IN_STOCK, null);
                    System.out.printf("Книга \"%s\" зарегистрирована %s%n",
                                      file.getName(), file);
                    break;
                }
            }
        }
        System.out.println("\n\n");
    }
}
