package ru.maki;

public class OhTimes {

    public final static int dayInNormalYear = 365; // число дней в обычном году
    public final static int dayInLeapYear = 366; // число дней в високосном году

    // Проверка года на признак "високосности"
    //
    // В високосном году 366 дней, в обычном 365.
    // Високосный год — это год, номер которого делится без остатка на 400 (например 2000 или 2400),
    // либо делится на 4 но не делится на 100 (например 2008, 2096, но не 2100).
    public static boolean isLeapYear(int year) {
        return (year % 400 == 0
                || (year % 4 == 0 && year % 100 != 0));

    }

    // Число дней в году
    public static int getDayInYear(int year) {
        int dayInYear = dayInNormalYear;
        if (isLeapYear(year)) dayInYear = dayInLeapYear;

        return dayInYear;
    }

}