import ru.maki.File;
import ru.maki.staff.Administrator;
import ru.maki.staff.Librarian;
import ru.maki.staff.Supplier;
import ru.maki.staff.User;
import ru.maki.role.Role;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // сначала зарегаем библиотеку (картотека Книг)
        File[] files = new File[0];

        // затем зарегаем Библиотекаря и Администратора
        Librarian uLibrarian = new Librarian("Главная", "Розария", "Олимповна",
                                        LocalDate.of(1939, 1, 5));
        Administrator uAdministrator = new Administrator("Начитанная", "Антонина", "Павловна",
                                                LocalDate.of(1950, 4, 8));

        // в какой-то момент выбираем поставщика
        Supplier uSupplier = new Supplier("Доставкин", "Федор", "Петрович",
                                      LocalDate.of(1993, 8, 14));

        // и начинаем закупку книг у выбранного поставщика
        files = uLibrarian.makeOrder(uSupplier, new File[]{
                new File("Словарь бранной лексики"),
                new File("Букварь")
        }, files);

        // доставка
        uSupplier.delieverOrder(uAdministrator, new File[]{
                new File("Словарь бранной лексики"),
                new File("Букварь")
        }, files);

        // заказ
        files = uLibrarian.makeOrder(uSupplier, new File[]{
                new File("Библия")
                , new File("Детская Энциклопедия")
                , new File("Философия JAVA")
        }, files);

        // окинем взором наше богатство
        // showList(files);

        // попытка взять книгу, которая еще в доставке
        uAdministrator.searchBook("Философия JAVA", files);

        // доставка
        uSupplier.delieverOrder(uAdministrator, new File[]{
                new File("Библия")
                , new File("Детская Энциклопедия")
                , new File("Философия JAVA")
        }, files);

        // окинем взором наше богатство
        // showList(files);

        // затем зарегаем Читателя
        User uReader = new User("Ковальчук", "Александр", "Михайлович",
                                LocalDate.of(1979, 11, 25));


        uAdministrator.searchBook("Словарь бранной лексики", files);
        uAdministrator.giveBook(uSupplier,"Словарь бранной лексики", files);

        // Читатель интересуется, где бы ему найти книгу "Философия JAVA" ... и
        // получает ответ от Администратора
        uAdministrator.searchBook("Философия JAVA", files);
        uAdministrator.searchBook("Философия Платона", files);


        // затем можем выдавать книги
        uAdministrator.giveBook(uReader,"Словарь бранной лексики", files);
        uAdministrator.giveBook(uReader,"Букварь", files);
        uAdministrator.giveBook(uReader,"Библия", files);
        uAdministrator.giveBook(uReader,"Детская Энциклопедия", files);
        uAdministrator.giveBook(uReader,"Философия JAVA",files);

        // по мере прочтения - возвращаем их в Библиотеку
        uReader.returnBook(uAdministrator,1, files);

        uReader.returnBook(uAdministrator,2, files);

        uReader.returnBook(uAdministrator, 4, files);


        uAdministrator.giveBook(uSupplier,"Словарь бранной лексики", files);
        uAdministrator.giveBook(uSupplier,"Букварь", files);


        // если задержали больше срока - получаем уведомление о просрочке
        uAdministrator.lateNotice(uReader, files);
        uAdministrator.lateNotice(uSupplier, files);

    }

    public static void showList(File[] files) {
        for (File file : files) {
            System.out.println(file.toString());
        }
        System.out.println("\n\n");

    }
}