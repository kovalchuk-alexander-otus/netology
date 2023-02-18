package ru.maki;

import ru.maki.errors.IllegalArgumentException;
import ru.maki.errors.IllegalStateException;

public class PasswordChecker {

    public final static String SUITABLE = "Подходит!";
    public final static String NOT_SUITABLE = "Не подходит!";
    boolean isSetPolitic; // признак, что политика безопасночти настроена
    int minLength; // минимально допустимая длина пароля
    int maxRepeats; // максимально допустимое количество повторений символа подряд

    public void setMinLength(int minLength) {
        if (minLength < 0) {
            throw new IllegalArgumentException(minLength);
        }
        this.minLength = minLength;
        this.isSetPolitic = true;
    }

    public void setMaxRepeats(int maxRepeats) {
        if (maxRepeats <= 0) {
            throw new IllegalArgumentException(maxRepeats);
        }
        this.maxRepeats = maxRepeats;
        this.isSetPolitic = true;
    }

    // проверка соответствия пароля требованиям политики безопасности
    public boolean verify(String password) {
        // ? политики безопасности установлены
        if (!this.isSetPolitic) {
            throw new IllegalStateException();
        }
        // ? длина пароля соответствует политике безопасности
        if (password.length() < this.minLength) {
            return false;
        }
        // ? число повторений символов подряд соответствует политике безопасности
        return PasswordChecker.calcMaxRepeats(password) <= this.maxRepeats;
    }

    // подсчет максимального количества одинаковых символов подряд
    public static int calcMaxRepeats(String password) {
        int counter = 0;
        int maxRepeats = 0;
        char lastChar = 0;

        for (char o : password.toCharArray()) {
            if (counter == 0) {
                counter++;
            } else {
                if (lastChar == o) {
                    counter++;
                } else {
                    maxRepeats = Math.max(maxRepeats, counter);
                    counter = 1;
                }
            }
            lastChar = o;
        }

        return Math.max(maxRepeats, counter);
    }
}
