import ru.maki.*;
import ru.maki.enums.Country;
import ru.maki.enums.Gender;
import ru.maki.enums.Genre;
import ru.maki.enums.Lang;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {

        printDelimiter("регистрируем авторов в online-market..");
        Author author1 = new Author("Пушкин", "Александр", "Сергеевич", Gender.MALE,
                new GregorianCalendar(1799, Calendar.MAY , 26),
                new GregorianCalendar(1837, Calendar.JANUARY , 29),
                "", Country.RUSSIA, Genre.POETRY
                );

        Author author2 = new Author("Гоголь", "Николай", "Васильевич", Gender.MALE,
                new GregorianCalendar(1809, Calendar.MARCH , 20),
                new GregorianCalendar(1852, Calendar.FEBRUARY , 21),
                "", Country.RUSSIA,
                Genre.NOVEL
        );

        Author author3 = new Author("Ковальчук", "Александр", "Михайлович", Gender.MALE,
                new GregorianCalendar(1979, Calendar.NOVEMBER , 25),
                Author.defaultDate,
                "живет такой парень", Country.RUSSIA,
                Genre.POETRY
        );

        printDelimiter("заполним биографию..");
        author1.setBiography("ай да Пушкин, ай да с*кин сын");

        printDelimiter("регистрируем книгу в online-market..");
        Book book = new Book(author1, "Онегин", Lang.RUS,
                Genre.NOVEL, 345,
                2021, 343.23);

        printDelimiter("загружаем текст..");
        book.loadText("пум-пум-пум ... скажи ка дядя ведь недаром Москва");

        printDelimiter("по запросу читателя, предоставляем ознакомительный фрагмент..");
        book.readBook(true);

        printDelimiter("ищем фрагмент..");
        System.out.println(book.searchText("скажи ка дядя"));

        printDelimiter("выводим book.toString");
        System.out.println(book);
        printDelimiter("выводим author2.toString");
        System.out.println(author2);
        printDelimiter("выводим author3.toString");
        System.out.println(author3);

        printDelimiter("заводим юзверей..");
        User user1 = new User("Иванов", "Иван", "Иваглвич", Gender.MALE,
                new GregorianCalendar(1965,Calendar.NOVEMBER,23));
        User user2 = new User("Петров", "Иван", "Иваглвич", Gender.MALE,
                new GregorianCalendar(1965,Calendar.NOVEMBER,23));
        User user3 = new User("Сидоров", "Иван", "Иваглвич", Gender.MALE,
                new GregorianCalendar(1965,Calendar.NOVEMBER,23));

        printDelimiter("проверим количество заведенных в системе пользаков..");
        System.out.println(User.getUserCount());
    }

    public static void printDelimiter(String whatAmIDoing) {
        System.out.println("");
        System.out.println(whatAmIDoing);
        System.out.println("-----------------------------------------------------");
    }
}