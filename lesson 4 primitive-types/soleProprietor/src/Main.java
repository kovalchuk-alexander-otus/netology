import ru.maki.Tax;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tax tax = new Tax(0.0, 0.0);
        String input = "";
        int idx = 0;

        while (true) {
            System.out.println("Выберите операцию и введите её номер:\n" +
                    "1. Добавить новый доход\n" +
                    "2. Добавить новый расход\n" +
                    "3. Выбрать ситему налогооблажения\n" +
                    "для завершения работы введите \"end\"");
            input = scanner.nextLine();
            // System.out.println(input);

            if ("end".equals(input)) {
                break;
            } else {
                try {
                    idx = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    idx = -1;
                }
            }
            switch (idx) {
                case 1:
                    System.out.print("Введите сумму дохода: ");
                    tax.addIncome(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Введите сумму расхода: ");
                    tax.addConsumption(scanner.nextLine());
                    break;
                case 3:
                    tax.bestChoice();

                    tax = new Tax(0.0, 0.0);
                    break;
                default:
                    System.out.println("Такой операции нет.");
            }
        }

        scanner.close();
    }
}
