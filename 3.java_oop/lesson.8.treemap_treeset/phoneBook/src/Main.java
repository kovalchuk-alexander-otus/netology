import ru.maki.Contact;
import ru.maki.MissedCalls;
import ru.maki.PhoneBook;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        MissedCalls missedCalls = new MissedCalls();

        // группа контактов создается автоматом, при первом упоминании в момент
        // заведения номера
        phoneBook.addContact("Друзья", "Макс", "7545523452");
        phoneBook.addContact("Друзья", "Петр", "7545426412");

        // поиск по группе ...по имени
        Contact petr = phoneBook.searchInGroup("Друзья", "Петр");
        System.out.println(petr);
        phoneBook.addContact("Работа", petr);


        // поиск по номеру
        Contact contact = phoneBook.searchByNumber("7545523452");
        System.out.println(contact);

        // добавляем группу контактов
        phoneBook.addGroup("Семья");
        phoneBook.addContact("Друзья", "Алексей", "7545428812");
        phoneBook.addContact("Семья", "Алексей", "7545428812");

        System.out.println(phoneBook);

        // забыл телефон дома
        System.out.println();
        missedCalls.setMissedCalls("7545428812");
        missedCalls.setMissedCalls("9036735424");
        missedCalls.setMissedCalls("7376542425");
        missedCalls.setMissedCalls("7545523452");
        missedCalls.setMissedCalls("9092342424");
        missedCalls.setMissedCalls("9472452425");
        missedCalls.setMissedCalls("4367342424");
        missedCalls.setMissedCalls("9092342425");
        missedCalls.setMissedCalls("7545523452");

        missedCalls.printMissedCalls(phoneBook);

        missedCalls.clearMissedCalls();

        System.out.println();
        missedCalls.printMissedCalls(phoneBook);

    }
}