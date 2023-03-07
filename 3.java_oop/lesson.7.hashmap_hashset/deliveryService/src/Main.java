import ru.maki.Address;
import ru.maki.Order;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Map<Address, BigDecimal> costPerAddress = new HashMap<>();

        costPerAddress.put(new Address("Россия", "Москва"), new BigDecimal("10.5"));
        costPerAddress.put(new Address("Россия", "Казань"), new BigDecimal("34.75"));
        costPerAddress.put(new Address("Россия", "Липецк"), new BigDecimal("10.0"));
        costPerAddress.put(new Address("Россия", "Воронеж"), new BigDecimal("10.0"));
        costPerAddress.put(new Address("Китай", "Ухань"), new BigDecimal("76.70"));
        costPerAddress.put(new Address("Индия", "Нью-дели"), new BigDecimal("81.23"));

        String country;
        String city;
        String input;
        BigDecimal weight;
        BigDecimal price;
        try (Scanner scanner = new Scanner(System.in)) {
            Order orders = new Order(costPerAddress);
            while (true) {
                System.out.println("\nЗаполнение нового заказа.");
                System.out.print("Введите страну: ");
                country = scanner.nextLine();

                if (country.contains("end")) {
                    break;
                }

                System.out.print("Введите город: ");
                city = scanner.nextLine();
                System.out.print("Введите вес (кг): ");
                input = scanner.nextLine();

                try {
                    weight = new BigDecimal(input);
                } catch (NumberFormatException e) {
                    System.out.println("Вы ввели неверный вес. " + e.getMessage());
                    continue;
                }

                price = orders.addOrder(new Address(country, city), weight);
                if (price == null) {
                    System.out.println("Доставки по этому адресу нет");
                } else {
                    System.out.printf("Стоимость доставки составит: %s руб.%n", price);
                    System.out.printf("Общая стоимость всех доставок: %s руб.%n", orders.getFullPrice()
                            .toString());
                }
            }

            orders.showCountCountry();
        }
    }
}