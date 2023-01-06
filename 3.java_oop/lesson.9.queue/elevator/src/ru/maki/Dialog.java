package ru.maki;

import java.util.Scanner;

public class Dialog {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getInteger(String message) {
        String input = "";
        try {
            System.out.print(message);
            input = scanner.nextLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.printf("Вы ввели не число [%s]. Попробуйте еще раз.%n", input);
            return -1;
        }
    }
}
