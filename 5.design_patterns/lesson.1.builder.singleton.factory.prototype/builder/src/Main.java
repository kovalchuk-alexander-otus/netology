import ru.maki.Person;
import ru.maki.PersonBuilder;

public class Main {
    public static void main(String[] args) {

        Person mom = new PersonBuilder()
                .setName("Вероника")
                .setSurname("Лихова")
                .setAddress("Москва")
                .build();
        System.out.println(mom);

        Person person = new PersonBuilder()
                .setName("Антон")
                .setSurname("Лихов")
                .setAge(18)
                .setAddress("Москва")
                .build();
        System.out.println(person);

        Person child = person
                .newChildBuilder()
                .setName("Константин")
                .build();
        System.out.println(child);

        try {
            // Не хватает обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder()
                    .setAge(-100)
                    .build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}