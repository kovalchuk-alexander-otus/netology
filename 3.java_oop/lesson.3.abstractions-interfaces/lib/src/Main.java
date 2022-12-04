import ru.maki.File;
import ru.maki.staff.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // сначала зарегаем библиотеку (картотека Книг)
        File[] files = new File[0];
        // test1(files); // пример Библиотеки, где каждый занят своим делом
        test2(files); // пример маленькой Библиотеки, где вся кухня на одном человеке

    }

    public static void showList(File[] files) {
        for (File file : files) {
            System.out.println(file.toString());
        }
        System.out.println("\n\n");

    }

    private static void test1(File[] files) {
        // затем зарегаем Библиотекаря и Администратора
        LibrarianImpl uLibrarian = new LibrarianImpl("Главная", "Розария", "Олимповна",
                                                     LocalDate.of(1939, 1, 5));
        System.out.println(uLibrarian);
        AdministratorImpl uAdministrator = new AdministratorImpl("Начитанная", "Антонина", "Павловна",
                                                                 LocalDate.of(1950, 4, 8));
        System.out.println(uAdministrator);
        // в какой-то момент выбираем поставщика
        SupplierImpl uSupplier = new SupplierImpl("Доставкин", "Федор", "Петрович",
                                                  LocalDate.of(1993, 8, 14));
        System.out.println(uSupplier);
        // и начинаем закупку книг у выбранного поставщика
        files = uLibrarian.makeOrder(uSupplier, new File[]{
                new File("Словарь бранной лексики"),
                new File("Букварь")
        }, files);

        // доставка
        uSupplier.deliveryOrder(uAdministrator, new File[]{
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
        uSupplier.deliveryOrder(uAdministrator, new File[]{
                new File("Библия")
                , new File("Детская Энциклопедия")
                , new File("Философия JAVA")
        }, files);

        // окинем взором наше богатство
        showList(files);

        // затем зарегаем Читателя
        ReaderImpl uReader = new ReaderImpl("Ковальчук", "Александр", "Михайлович",
                                            LocalDate.of(1979, 11, 25));
        System.out.println(uReader);

        uAdministrator.searchBook("Словарь бранной лексики", files);
        uAdministrator.giveBook(uSupplier, "Словарь бранной лексики", files);

        // Читатель интересуется, где бы ему найти книгу "Философия JAVA" ... и
        // получает ответ от Администратора
        uAdministrator.searchBook("Философия JAVA", files);
        uAdministrator.searchBook("Философия Платона", files);


        // затем можем выдавать книги
        uAdministrator.giveBook(uReader, "Словарь бранной лексики", files);
        uAdministrator.giveBook(uReader, "Букварь", files);
        uAdministrator.giveBook(uReader, "Библия", files);
        uAdministrator.giveBook(uReader, "Детская Энциклопедия", files);
        uAdministrator.giveBook(uReader, "Философия JAVA", files);

        // по мере прочтения - возвращаем их в Библиотеку
        uReader.returnBook(uAdministrator, 1, files);

        uReader.returnBook(uAdministrator, 2, files);

        uReader.returnBook(uAdministrator, 4, files);


        uAdministrator.giveBook(uSupplier, "Словарь бранной лексики", files);
        uAdministrator.giveBook(uSupplier, "Букварь", files);


        // если задержали больше срока - получаем уведомление о просрочке
        uAdministrator.lateNotice(uReader, files);
        uAdministrator.lateNotice(uSupplier, files);

        System.out.println(uReader);
        System.out.println(uSupplier);
    }

    private static void test2(File[] files) {
        // затем зарегаем Библиотекаря и Администратора
        SmallLibraryWorker uStaff = new SmallLibraryWorker("Упорная", "Надежда",
                                                           "Ивановна",
                                                     LocalDate.of(1969, 3, 14));
        System.out.println(uStaff);

        // в какой-то момент выбираем поставщика
        SupplierImpl uSupplier = new SupplierImpl("Доставкин", "Федор", "Петрович",
                                                  LocalDate.of(1993, 8, 14));
        System.out.println(uSupplier);

        // и начинаем закупку книг у выбранного поставщика
        files = uStaff.makeOrder(uSupplier, new File[]{
                new File("Словарь бранной лексики"),
                new File("Букварь")
        }, files);

        // доставка
        uSupplier.deliveryOrder(uStaff, new File[]{
                new File("Словарь бранной лексики"),
                new File("Букварь")
        }, files);

        // заказ
        files = uStaff.makeOrder(uSupplier, new File[]{
                new File("Библия")
                , new File("Детская Энциклопедия")
                , new File("Философия JAVA")
        }, files);

        // окинем взором наше богатство
        // showList(files);

        // попытка взять книгу, которая еще в доставке
        uStaff.searchBook("Философия JAVA", files);

        // доставка
        uSupplier.deliveryOrder(uStaff, new File[]{
                new File("Библия")
                , new File("Детская Энциклопедия")
                , new File("Философия JAVA")
        }, files);

        // окинем взором наше богатство
        showList(files);

        // затем зарегаем Читателя
        ReaderImpl uReader = new ReaderImpl("Ковальчук", "Александр", "Михайлович",
                                            LocalDate.of(1979, 11, 25));
        System.out.println(uReader);

        uStaff.searchBook("Словарь бранной лексики", files);
        uStaff.giveBook(uSupplier, "Словарь бранной лексики", files);

        // Читатель интересуется, где бы ему найти книгу "Философия JAVA" ... и
        // получает ответ от Администратора
        uStaff.searchBook("Философия JAVA", files);
        uStaff.searchBook("Философия Платона", files);


        // затем можем выдавать книги
        uStaff.giveBook(uReader, "Словарь бранной лексики", files);
        uStaff.giveBook(uReader, "Букварь", files);
        uStaff.giveBook(uReader, "Библия", files);
        uStaff.giveBook(uReader, "Детская Энциклопедия", files);
        uStaff.giveBook(uReader, "Философия JAVA", files);

        // по мере прочтения - возвращаем их в Библиотеку
        uReader.returnBook(uStaff, 1, files);

        uReader.returnBook(uStaff, 2, files);

        uReader.returnBook(uStaff, 4, files);


        uStaff.giveBook(uSupplier, "Словарь бранной лексики", files);
        uStaff.giveBook(uSupplier, "Букварь", files);


        // если задержали больше срока - получаем уведомление о просрочке
        uStaff.lateNotice(uReader, files);
        uStaff.lateNotice(uSupplier, files);

        System.out.println(uReader);
        System.out.println(uSupplier);
    }
}