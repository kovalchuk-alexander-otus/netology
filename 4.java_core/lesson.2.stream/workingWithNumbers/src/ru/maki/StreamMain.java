package ru.maki;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamMain {

    // пример работы с Stream API : на вход принимаем массив int[]
    public static void doIntStream(int[] numbers) {
        System.out.println("\n ПРИМЕР  РАБОТЫ С IntStream");
        Arrays.stream(numbers)
                .boxed()
                .filter(v -> v > 0)
                .filter(v -> v % 2 == 0)
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);

//        Stream<Integer> streamOfArray = Arrays.stream(numbers)
//                .boxed();
//        streamOfArray.filter(v -> v > 0)
//                .filter(v -> v % 2 == 0)
//                .sorted(Comparator.naturalOrder())
//                .forEach(System.out::println);
    }

    // пример работы с Stream API : на вход принимаем массив Integer[]
    public static void doStreamInteger(Integer[] numbers) {
        System.out.println("\n ПРИМЕР  РАБОТЫ С Stream<Integer>");
        List<Integer> intList = Arrays.asList(numbers);
        Stream<Integer> stream = intList.stream();
        stream.filter(v -> v > 0)
                .filter(v -> v % 2 == 0)
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
    }


}
