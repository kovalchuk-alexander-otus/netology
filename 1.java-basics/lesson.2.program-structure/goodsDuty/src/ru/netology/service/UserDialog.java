package ru.netology.service;

import java.util.Scanner;

public class UserDialog {
    public static final Scanner scanner = new Scanner(System.in);

    // зададим вопрос пользователю
    public static int askAQuestion(String question) {
        System.out.print(question);
        return scanner.nextInt();
    }
}
