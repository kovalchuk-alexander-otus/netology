package ru.maki;

import java.util.Scanner;

public class Dialog {

    private static final Scanner scanner = new Scanner(System.in);

    // перегрузка метода getInteger - для случая с одним аргументом
    public static int getInteger(String message) throws Exception {
        return getInteger(message, 1)[0];
    }

    // универсальная реализация метода с произвольным числом аргументов
    public static int[] getInteger(String message, int argumentCount) throws Exception {
        int[] retVal = new int[argumentCount];
        String[] sVal;

        System.out.print(message);
        String input = scanner.nextLine();
        try {
            sVal = input.split(" ");
            // TODO: в идеале тут стоит добавить проверку размера массива и числа аргументов
            for (int i = 0; i < argumentCount; i++) {
                retVal[i] = Integer.parseInt(sVal[i]);
            }
        } catch (Exception e) {
            throw new Exception("Вы ввели значение не по шаблону [" + input + "]. Попробуйте еще раз.\n\n");
        }
        return retVal;
    }
}
