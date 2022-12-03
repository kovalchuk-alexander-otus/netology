package ru.maki;
import java.util.Scanner;

public class Dialog {
    static final Scanner scanner = new Scanner(System.in);

    // диалог с пользователем с ожиданием Целого числа
    public static int getAnswer(String message, String errMessage) throws Exception {
        int i;
        System.out.print(message);
        String input = scanner.nextLine();
        try {
            i = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(errMessage);
            System.out.println();
            throw new Exception(errMessage);
        }
        return i;
    }

    // диалог с пользователем с ожиданием Строки
    public static String getAnswer(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
}
