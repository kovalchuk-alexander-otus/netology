import ru.maki.Student;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Student> students = new HashSet<>();
        String input;
        String[] record;

        // диалог с пользователем
        while (true) {
            System.out.println("Введите информацию о студенте: \"ФИО, номер группы, номер студенческого билета\"\n" +
                    "(для завершения работы программы введите \"end\")\n > ");
            input = scanner.nextLine();
            if (input.equals("end")) break;

            record = input.split(",");
            if (record.length != 3) {
                System.out.println("Не корректно введена запись - заполняйте в соответствии с шаблоном!");
                continue;
            }

            Student student = new Student(record[0].trim(), record[1].trim(), record[2].trim());
            if (students.contains(student)) {
                System.out.printf("Ошибка! Студент с номером студенческого билета [%s] уже сохранен в системе.%n",
                        record[2].trim());
            } else {
                students.add(student);
            }
        }

        // выводим на экран
        for (Student student : students) {
            System.out.println(student);
        }
    }
}