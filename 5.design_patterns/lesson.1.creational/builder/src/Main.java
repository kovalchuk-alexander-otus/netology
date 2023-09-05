import ru.maki.Person;
import ru.maki.PersonBuilder;

public class Main {
    public static void main(String[] args) {
//        Person ivan = new PersonBuilder().setName("Иван").setSurname("Грибков").setCity("Питер").setAge(9).build();
//        System.out.println(ivan);
//
//        ivan.happyBirthday();
//
//        System.out.println(ivan.hasAddress());
//
//        System.out.println(ivan.hasAge());
//
//        PersonBuilder childBuilder = ivan.newChildBuilder();
//        Person child = childBuilder.setName("Бенечка").build();
//        System.out.println(child);
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);

        try {
            // Не хватает обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

}