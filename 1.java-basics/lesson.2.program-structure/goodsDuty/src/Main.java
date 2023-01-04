import static ru.netology.service.CustomsService.getAmountOfDuty;
import static ru.netology.service.UserDialog.askAQuestion;

public class Main {
    public static void main(String[] args) {
        int price = askAQuestion("Введите цену товара (в руб.): ");
        int weight = askAQuestion("Введите вес товара (в кг.): ");
        System.out.printf("%nРазмер пошлины (в руб.) составит: %d%n", getAmountOfDuty(price, weight));
    }
}