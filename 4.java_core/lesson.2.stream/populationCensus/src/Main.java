import ru.maki.Education;
import ru.maki.Person;
import ru.maki.Sex;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static final Random random = new Random();

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        List<String> listOfMaleName = Arrays.asList("Александр", "Иннокентий", "Кондратий", "Савелий", "Константин",
                "Евпатий", "Порфирий");
        List<String> listOfFemaleName = Arrays.asList("Варвара", "Прасковья", "Вероника", "Аркадия", "Мелания",
                "Наталья", "Алевтина");
        List<String> listOfSurname = Arrays.asList("Красовский", "Перчиков", "Мусорский", "Чайковский", "Чуб",
                "Пронский", "Смирнов", "Воронцов", "Гречко");

        String name;
        String surname;
        Sex sex;

        for (int i = 0; i < 10_000; i++) {
            sex = Sex.values()[random.nextInt(Sex.values().length)];
            name = sex == Sex.MALE ? listOfMaleName.get(random.nextInt(listOfMaleName.size())) :
                    listOfFemaleName.get(random.nextInt(listOfFemaleName.size()));
            surname = listOfSurname.get(random.nextInt(listOfSurname.size()));
            people.add(new Person(name, surname, random.nextInt(100), sex,
                    Education.values()[random.nextInt(Education.values().length)]));
        }

        // Найти количество несовершеннолетних (т.е. людей младше 18 лет).
        System.out.printf(Locale.ITALY, "Количество несовершеннолетних: %,d%n%n", people.stream()
                .filter(v -> v.getAge() < 18)
                .count());

        // Получить список фамилий призывников (т.е. мужчин от 18 и до 27 лет).
        List<String> surNames =
                people.stream()
                        .filter(v -> v.getAge() >= 18 && v.getAge() <= 27)
                        .map(Person::getSurname)
                        .collect(Collectors.toList());
        System.out.printf(Locale.ITALY, "Список призывников: %,d%n%n", surNames.size());

        // Получить отсортированный по фамилии список потенциально работоспособных людей с высшим образованием в
        //   выборке (т.е. людей с высшим образованием от 18 до 60 лет для женщин и до 65 лет для мужчин).
        List<Person> workers = people.stream()
                .filter(v -> v.getAge() >= 18 &&
                        (v.getAge() <= 60 && v.getSex() == Sex.FEMALE || v.getAge() <= 65 && v.getSex() == Sex.MALE))
                .filter(v -> v.getEducation() == Education.HIGHER)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println("Список работоспособных тунеядцев: ");
        System.out.println(workers);
    }
}