package ru.maki;

import ru.maki.client.*;
import ru.maki.product.Bread;
import ru.maki.product.Meat;
import ru.maki.product.Product;
import ru.maki.shop.*;

import java.text.SimpleDateFormat;
import java.util.*;

import static ru.maki.client.Country.RUSSIA;

public class Main {
    final String END = "end";

    public static void main(String[] args) {

        // инициируем магазин (ну, типа откуда-то подгружаем товары)
        Stock.init();

        // имитируем завоз товаров на склад
        Stock.get()
                .addProducts(new Meat("Мираторг", 200, 0, RUSSIA, Meat.MeatType.LAMB, true), 100)
                .addProducts(new Meat("Мираторг", 200, 0, RUSSIA, Meat.MeatType.PORK, true), 100)
                .addProducts(new Bread("Зерновик", 75, 0, RUSSIA, false, false, true), 50)
                .addProducts(new Meat("Мираторг", 250, 0, RUSSIA, Meat.MeatType.BEEF, true), 50)
                .addProducts(new Meat("Мираторг", 450, 0, RUSSIA, Meat.MeatType.BEEF, false), 10)
                .printGoodsInStock("Склад обновлен..");


        // имитируем процесс покупки - состоит из стадий:
        //   наполнение корзины,
        //   оформления заказа

        // ..наполнение Корзины
        Cart cart = new Cart();
        String input;
        int count;
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Выберите \"Раздел каталога\"");
                Stock.get()
                        .showProductsType(); // выберите Раздел каталога
                input = scanner.nextLine();

                if (Stock.get()
                        .showUniqueProductParams(input)) {
                    System.out.println("Выберите \"Продукт\"");
                    Stock.get()
                            .showProducts(input); // выберите Продукт
                    String[] params = scanner.nextLine()
                            .split(" ");
                    System.out.println(Arrays.toString(params));

                    try {
                        Product product = Stock.get()
                                .getProductByParams(params);
                        System.out.println(product);
                        System.out.println("Укажите желаемое количество: ");
                        count = Integer.parseInt(scanner.nextLine());
                        cart.addProduct(product, count);
                        System.out.println(cart);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                System.out.println("В случае, если вы закончили выбор Продукции - введите \"end\".");
                input = scanner.nextLine();
                if (input.equals("end")) {
                    break;
                }
            }
        }

        // ..оформление Заказа
        cart.printProducts("В корзине: ");

        // трекинг Заказа и его контроль
        OrderBuilder orderBuilder = new OrderBuilderImpl();

        // ..подтверждение перечня продуктов в заказе
        orderBuilder.setCart(cart);

        // ..заведение Клиента с нуля
        Map<ContactsType, Contact> contacts = new HashMap<>();
        contacts.put(ContactsType.PHONE, new Phone("+7(322)323-22-44"));
        contacts.put(ContactsType.MAIL, new Mail("mail@gmail.com"));

        Client client = new Client("Alex", "Kovach", contacts,
                new Address(RUSSIA, City.SAINT_PETERSBURG, "Nevsky avenue", 23, 35));
        orderBuilder.setClient(client);

        // ..заведение информации о доставке (доставка на дом)
        orderBuilder.setDeliveryInfo(client.getAddress(), client.getContacts(), new GregorianCalendar(2023,
                Calendar.JANUARY, 25));

        // ..заведение информации о способе оплаты
        orderBuilder.setPaymentInfo(PaymentMethod.CASH);

        System.out.println(orderBuilder);

        // ..формирование заказа
        Order order = orderBuilder.build (DeliveryMethod.DELIVERY);

        System.out.println(order);

        //


        //  клиент
        //  корзина покупателя (HashMap - товар, количество)
        //  сервис доставки - трекинг?

        // TODO: Вывод доступных для покупки товаров
        // TODO: Фильтрация товаров по ключевым словам, ценам, производителям
        // TODO: Составление продуктовой корзины пользователя
        // TODO: Трекинг заказа в системе доставки
        // TODO: Возврат заказа, повтороение заказа
        // TODO: Система рейтинга для товаров
        // TODO: Простая рекомендательная система для покупок
    }
}