import ru.maki.Author;
import ru.maki.Book;

public class Main {
    public static void main(String[] args) {

        Book book = new Book("Властелин колец", 2021,
                new Author("Джон", "Толкин", 9), 2234);
        System.out.println(book);

        System.out.printf("%nПримерная стоимость [%d рублей]%n", book.estimatePrice());
        System.out.printf("%nБольшая книга? [%s]%n", book.isBig() ? "да" : "нет");
        System.out.printf("%nОисание содержит \"Толик\" [%s]%n", book.matches("Толик") ? "да" : "нет");
        System.out.printf("%nОисание содержит \"Толкин\" [%s]%n", book.matches("Толкин") ? "да" : "нет");
        System.out.printf("%nОисание содержит \"оле\" [%s]%n", book.matches("оле") ? "да" : "нет");
    }
}