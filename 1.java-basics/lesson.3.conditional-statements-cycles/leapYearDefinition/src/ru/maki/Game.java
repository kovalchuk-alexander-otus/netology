package ru.maki;

import static ru.maki.Dialog.getInteger;
import static ru.maki.Times.getDayInYear;

public class Game {

    private static final int I_YEAR = 0;
    private static final int I_DAYS = 1;

    // игра "Угадай число дней в году"
    public static void guessLeapYear() {
        int gameScore = 0;
        while (true) {
            try {
                int[] move = getInteger("Введите год и количество дней в формате [yyyy 365] или [yyyy 366] : ", 2);
                // TODO: в идеале тут делать проверку второго аргумента на равнество 365 или 366
                if (getDayInYear(move[I_YEAR]) == move[I_DAYS]) gameScore += 1;
                else break;
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        System.out.printf("Поздравляем, ваш результат [%d] очков.", gameScore);
    }
}
