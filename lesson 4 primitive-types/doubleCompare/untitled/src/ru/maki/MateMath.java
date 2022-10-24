package ru.maki;

import java.util.Scanner;

public class MateMath {

    static final double EPSILON = 1e-16;
    static Scanner scanner = new Scanner(System.in);

    // диалог с пользователем
    private static double dialogue(String question) {
        try {
            System.out.print(question);
            String input = scanner.nextLine();
            //TODO : так и не прокурил, как закрыть scanner
            // здесь нельзя, т.к. возникает ошибка при вводе второго числа
            // scanner.close();
            double result = Double.parseDouble(input);
            // System.out.println("отладка:" + result);
            return result;
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    // сравнение
    public static String compare() {
        double value1 = dialogue("Введите первое число: ");
        double value2 = dialogue("Введите второе число: ");
        return Math.abs(value1 - value2) < EPSILON ? "числа равны" : value1 > value2 ? "первое число больше" : "второе число больше";
    }

    // округление
    public static long round() {
        double value = dialogue("Введите число: ");

        return Math.round(value);
    }

    // отбросить дробную часть
    public static long discardFractional() {
        double value = dialogue("Введите число: ");

        return (long) value;
    }
}
