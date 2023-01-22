package ru.maki;

public class Check {
    static final StringBuilder stringBuilder = new StringBuilder();

    public static void printLNResult(String text) {
        stringBuilder.append(text);
        stringBuilder.append("\n");
        System.out.println(text);
    }

    public static void printResult(String text) {
        stringBuilder.append(text);
        System.out.print(text);
    }

    public static void viewResult() {
        System.out.println(stringBuilder);
    }

    public static void checkResult(String gage) {
        if (stringBuilder.toString().equals(gage)) {
            System.out.println("Поздравляем, вы таки да!");
        } else {
            System.out.println("Что-то пошло не так...");
        }
    }
}
