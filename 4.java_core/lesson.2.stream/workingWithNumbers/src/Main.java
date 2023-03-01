import ru.maki.StreamMain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] numberInt = {1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4};

        Integer[] numbers = Arrays.stream(numberInt)
                .boxed()
                .toArray(Integer[]::new);

        StreamMain.doIntStream(numberInt);
        StreamMain.doStreamInteger(numbers);

        doList(numbers);

    }

    // пример работы с методами Коллекции
    public static void doList(Integer[] numbers) {
        System.out.println("\n ПРИМЕР  РАБОТЫ С List<Integer>");
        List<Integer> intList = Arrays.asList(numbers);
        intList.sort(Comparator.naturalOrder());
        // intList.forEach(System.out::println);
        for (int value : intList) {
            if (value > 0 && value % 2 == 0) {
                System.out.println(value);
            }
        }
    }
}