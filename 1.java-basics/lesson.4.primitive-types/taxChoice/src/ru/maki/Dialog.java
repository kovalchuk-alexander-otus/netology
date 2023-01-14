package ru.maki;

import java.util.Scanner;

public class Dialog {

    private static final Scanner scanner = new Scanner(System.in);

    // диалог, возвращающий целое число
    public static int getInt(String message) throws RuntimeException {
        int result;

        System.out.println(message);
        String input = scanner.nextLine();

        if ("end".equals(input)) {
            return -1;
        }
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new RuntimeException(input);
        }

        return result;
    }

    // TODO: диалог, возвращающий текст

    // диалог, возвращающий число с плавающей точкой
    public static double getDouble(String message) {
        double result;

        System.out.println(message);
        String input = scanner.nextLine();

        try {
            result = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return 0;
        }

        return result;
    }
}