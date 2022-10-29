import java.util.*;

import ru.maki.*;

class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        leapYear();
        scanner.close();

    }

    // Високосный год
    public static void leapYear() {
        beautifire("Високосный год");
        System.out.print("Введите год в формате \"yyyy\": ");
        int year = scanner.nextInt();

        int dayInYear = OhTimes.getDayInYear(year);

        System.out.println("Количество дней " + dayInYear);

        // альтернатива
        //
        // if (ohTimes.isLeapYear(year)) System.out.println("Количество дней 366");
        // else System.out.println("Количество дней 365");
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