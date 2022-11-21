import ru.maki.Book;
import ru.maki.File;
import ru.maki.User;
import ru.maki.role.Role;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // сначала зарегаем библиотеку (картотека Книг)
        File[] files = new File[0];

        // затем зарегаем Библиотекаря и Администратора
        User uLibrarian = new User("Главная", "Розария", "Олимповна",
                                   LocalDate.of(1939, 1, 5), Role.LIBRARIAN);
        User uAdministrator = new User("Начитанная", "Антонина", "Павловна",
                                       LocalDate.of(1950, 4, 8), Role.ADMINISTRATOR);

        // в какой-то момент выбираем поставщика
        User uSupplier = new User("Доставкин", "Федор", "Петрович",
                                  LocalDate.of(1993, 8, 14), Role.SUPPLIER);

        // и начинаем закупку книг у выбранного поставщика
        files = uLibrarian.makeOrder(new File[]{
                new File("Словарь бранной лексики"),
                new File("Букварь")
        }, files);

        // доставка
        uSupplier.delieverOrder(new File[]{
                new File("Словарь бранной лексики"),
                new File("Букварь")
        }, files);

        // заказ
        files = uLibrarian.makeOrder(new File[]{
                new File("Библия")
                , new File("Детская Энциклопедия")
                , new File("Философия JAVA")
        }, files);

        // попытка взять книгу, которая еще в доставке
        uAdministrator.searchBook("Философия JAVA", files);

        // доставка
        uSupplier.delieverOrder(new File[]{
                new File("Библия")
                , new File("Детская Энциклопедия")
                , new File("Философия JAVA")
        }, files);

        // окинем взором наше богатство
        showList(files);

        // затем зарегаем Читателя
        User uReader = new User("Ковальчук", "Александр", "Михайлович",
                                LocalDate.of(1979, 11, 25), Role.READER);


        uReader.searchBook("Словарь бранной лексики", files);
        uSupplier.takeBook("Словарь бранной лексики", files);

        // Читатель интересуется, где бы ему найти книгу "Философия JAVA" ... и
        // получает ответ от Администратора
        uAdministrator.searchBook("Философия JAVA", files);
        uAdministrator.searchBook("Философия Платона", files);


        // затем можем выдавать книги
        uReader.takeBook("Словарь бранной лексики", files);
        uReader.takeBook("Букварь", files);
        uReader.takeBook("Библия", files);
        uReader.takeBook("Детская Энциклопедия", files);
        uReader.takeBook("Философия JAVA",files);


        // по мере прочтения - возвращаем их в Библиотеку
        uReader.showBooks();

        uReader.returnBook(1, files);
        uReader.showBooks();

        uReader.returnBook(2, files);
        uReader.showBooks();

        uReader.returnBook(4, files);


        // если задержали больше срока - получаем уведомление о просрочке
        uAdministrator.lateNotice(files);

    }

    public static void showList(File[] files) {
        for (File file : files) {
            System.out.println(file.toString());
        }
        System.out.println("\n\n");

    }
}