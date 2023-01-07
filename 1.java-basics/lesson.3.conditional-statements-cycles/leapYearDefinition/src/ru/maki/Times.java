package ru.maki;

import static ru.maki.Dialog.getInteger;

public class Times {
    final static int DAYS_IN_LEAP_YEAR = 366;
    final static int DAYS_IN_NORMAL_YEAR = 365;

    // диалог: запросим у Пользователя год
    public static int getYear() {
        int year;
        try {
            year = getInteger("Введите год в формате yyyy : ");
        } catch (Exception e) {
            year = -1;
            System.out.println(e);
        }
        return year;
    }

    // число дней в году
    public static int getDayInYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0) ? DAYS_IN_LEAP_YEAR : DAYS_IN_NORMAL_YEAR;
    }
}
