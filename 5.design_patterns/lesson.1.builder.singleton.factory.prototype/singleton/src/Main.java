import ru.maki.Filter;
import ru.maki.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.get();
        logger.log("Запускаем программу");

        int listSize;
        int maxValue;
        try (Scanner scanner = new Scanner(System.in)) {
            logger.log("Просим пользователя ввести входные данные для списка");

            System.out.print("Введите размер списка: ");
            listSize = scanner.nextInt();
            System.out.print("Введите верхнюю границу для значений: ");
            maxValue = scanner.nextInt();

            logger.log("Создаем и наполняем список");

            Random random = new Random();
            List<Integer> list = new ArrayList<>();
            int i = listSize;
            int nextInt;
            System.out.print("Вот случайный список:");
            while (i > 0) {
                i--;
                nextInt = random.nextInt(maxValue);
                list.add(nextInt);
                System.out.printf(" %d%s", nextInt, i == 0 ? "\n" : "");
            }

            logger.log("Просим пользователя ввести входные данные для фильтрации");
            System.out.print("Введите порог для фильтра: ");
            int thresholdValue = scanner.nextInt();

            Filter filter = new Filter();
            List<Integer> newList = filter.filterOut(list, thresholdValue);
            logger.log(new StringBuilder()
                    .append("Прошло фильтр ")
                    .append(newList.size())
                    .append(" элемента из ")
                    .append(list.size())
                    .toString());
            logger.log("Выводим результат на экран");
            System.out.print("Отфильтрованный список:");
            newList.forEach(v -> System.out.printf(" %d", v));
            System.out.println();

            logger.log("Завершаем программу");
        }
    }
}