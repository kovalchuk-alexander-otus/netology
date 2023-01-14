import ru.maki.Dialog;
import ru.maki.Tax;

public class Main {
    public static void main(String[] args) {
        Tax tax = new Tax();
        int choice; // выбор пользователя
        double move; // движение средств (доход или расход в зависимости от знака)

        while (true) {
            try {
                choice = Dialog.getInt("Выберите операцию и введите её номер:\n" +
                        "  1. Добавить новый доход\n" +
                        "  2. Добавить новый расход\n" +
                        "  3. Выбрать ситему налогооблажения\n" +
                        " > ");
            } catch (RuntimeException e) {
                System.out.printf("Вы выбрали недопустимый вариант [%s]. Попробуйие еще раз.%n", e.getMessage());
                continue;
            }
            switch (choice) {
                case -1:
                    System.out.println("Вы выбрали завершение работы. До новых встреч.");
                    return;
                case 1:
                    move = Dialog.getDouble("Введите сумму дохода:\n" +
                            " > ");
                    tax.setIncome(move);
                    break;
                case 2:
                    move = Dialog.getDouble("Введите сумму расхода:\n" +
                            " > ");
                    tax.setExpense(move);
                    break;
                case 3:
                    tax.choiceBestTax();
                    System.out.println("Программа завершена!");
                    return;
            }
        }
    }
}