import java.util.*;

import ru.maki.*;

class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        gameOfYear();
        scanner.close();

    }

    // game "Угадываем високосность"
    public static void gameOfYear() {
        beautifire("game \"Угадываем високосность\"");
        int points = 0;
        while (true) {
            System.out.print("Введите год и количество дней в формате \"yyyy количество дней\": ");
            int year = scanner.nextInt();
            int dayInYear = scanner.nextInt();
            int realDayInYear = OhTimes.getDayInYear(year);

            if (realDayInYear == dayInYear) points++;
            else {
                System.out.println("Приятель, промашка, в году " + year + " - " + realDayInYear + " дней.");
                break;
            }
        }

        System.out.println("Поздравляю, Вы набрали " + points + " очков.");
    }

    // шапка диалога
    public static void beautifire(String topic) {
        System.out.println();
        System.out.println();
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println(topic);
        System.out.println("_____________________________");
    }
}