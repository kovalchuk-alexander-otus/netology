import ru.maki.MateMath;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = "";
        int idx = 0;

        System.out.println("Операции над double/float\n" +
                "1. Сравнить\n" +
                "2. Округлить\n" +
                "3. Отбросить дробную часть");

        try {
            input = scanner.nextLine();
            idx = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            idx = -1;
        }

        switch (idx) {
            case 1:
                System.out.printf("Результат: [%s] \n\n", MateMath.compare());
                break;
            case 2:
                System.out.printf("Результат: [%s] \n\n", MateMath.round());
                break;
            case 3:
                System.out.printf("Результат: [%s] \n\n", MateMath.discardFractional());
                break;
            default:
                System.out.println("Такой операции нет.");
        }

        scanner.close();
    }
}