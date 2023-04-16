package ru.maki.shop;

import ru.maki.client.Client;
import ru.maki.product.Bread;
import ru.maki.product.Meat;
import ru.maki.product.Milk;
import ru.maki.product.Product;

import java.util.*;

public class Stock {
    protected static Stock stock = null;
    protected Map<Client, List<Order>> clientHistory = new HashMap<>(); // структура для хранения информации по
    // заказам конкретного Клиента
    protected final Map<Product, Integer> products = new HashMap<>(); // каталог продукции на складе
    protected final Map<Product, Integer> reservation = new HashMap<>(); // информация о забронированном .. но не оплаченном на
    // данный момент товаре
    protected Queue<Order> paymentControl; // очередь контроля оплаты
    protected Queue<Order> assembly; // сборка
    protected Queue<Order> giftWrap; // подарочная упаковка
    protected Queue<Order> delivery; // доставка

    // создадим склад (Singleton)
    public static Stock get() {
        if (stock == null) {
            stock = new Stock();
        }
        return stock;
    }

    // инициализация склада при запуске программы (ну, например из файла или базы .. не запарился реализацией)
    public static void init() {
        Stock.get()
                .addProducts(new Milk("Простоквашино", 100, 0, Product.Country.RUSSIA, Milk.MilkType.MILK, 2.5), 100)
                .addProducts(new Milk("Простоквашино", 110, 0, Product.Country.RUSSIA, Milk.MilkType.KEFIR, 2.5), 100)
                .addProducts(new Milk("Простоквашино", 215, 0, Product.Country.RUSSIA, Milk.MilkType.COTTAGE_CHEESE, 9)
                        , 30)
                .addProducts(new Milk("Брест-литовск", 110, 0, Product.Country.BELARUS, Milk.MilkType.KEFIR, 2.5), 50)
                .addProducts(new Milk("Брест-литовск", 215, 0, Product.Country.BELARUS, Milk.MilkType.COTTAGE_CHEESE,
                                9),
                        20)
                .addProducts(new Meat("Мираторг", 250, 0, Product.Country.RUSSIA, Meat.MeatType.BEEF, true), 100)
                .addProducts(new Meat("Мираторг", 450, 0, Product.Country.RUSSIA, Meat.MeatType.BEEF, false), 100)
                .addProducts(new Bread("Кирпич", 45, 0, Product.Country.RUSSIA, true, true, false), 100)
                .addProducts(new Bread("Подмосковный", 38, 0, Product.Country.RUSSIA, false, false, false), 150)
                .addProducts(new Bread("Нарезной", 40, 0, Product.Country.RUSSIA, false, false, false), 150)
                .printGoodsInStock("Склад инициализирован..");
    }

    // добавим продукт на склад
    public Stock addProducts(Product product, int number) {
        if (this.products.containsKey(product)) {
            this.products.put(product, this.products.get(product) + number);
        } else {
            this.products.put(product, number);
        }
        return this;
    }

    // показывает число Продукта, доступного для бронирования/покупкиCa
    public int availableNumberOfProduct(Product product) {
        int productNumber = this.products.get(product);
        int bookingNumber = 0;
        if (!this.reservation.isEmpty()) {
            bookingNumber = this.reservation.get(product);
        }
        return productNumber - bookingNumber;
    }

    // выполняем резервирование продукта
    public void makeReservation(Product product, int number) {
        if (this.reservation.containsKey(product)) {
            this.reservation.put(product, this.reservation.get(product) + number);
        } else {
            this.reservation.put(product, number);
        }
    }

    // снимаем резерв (причины может быть две - отмена или оплата заказа)
    public void canselReservation(Product product, int number) {
        this.reservation.put(product, this.reservation.get(product) - number);
    }

    // выведем наличие товаров на складе
    public void printGoodsInStock(String message) {
        System.out.println("\n-----------------------------------");
        System.out.println(message);
        System.out.println("-----------------------------------");
        for (Map.Entry<Product, Integer> productIntegerEntry : this.products.entrySet()) {
            System.out.printf("%s [ %d / %d ]%n", productIntegerEntry.getKey(), availableNumberOfProduct(productIntegerEntry.getKey()),
                    productIntegerEntry.getValue());
        }

        Map<Product, Integer> map = new TreeMap<>(this.products);

        System.out.println();
        for (Map.Entry<Product, Integer> productIntegerEntry : map.entrySet()) {
            System.out.printf("%s [ %d / %d ]%n", productIntegerEntry.getKey(),
                    availableNumberOfProduct(productIntegerEntry.getKey()), productIntegerEntry.getValue());
        }
    }
}
