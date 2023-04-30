package ru.maki.shop;

import ru.maki.client.Client;
import ru.maki.product.Bread;
import ru.maki.product.Meat;
import ru.maki.product.Milk;
import ru.maki.product.Product;

import java.util.*;
import java.util.stream.Collectors;

import static ru.maki.client.Country.BELARUS;
import static ru.maki.client.Country.RUSSIA;

// Склад магазина
public class Stock {
    protected static Stock stock = null;
    protected final Map<Product, Integer> products = new HashMap<>(); // каталог продукции на складе
    protected final Map<Product, Integer> reservation = new HashMap<>(); // информация о забронированном .. но не оплаченном на
    // данный момент товаре
    protected Map<Client, List<Order>> clientHistory = new HashMap<>(); // структура для хранения информации по
    // заказам конкретного Клиента
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
                .addProducts(new Milk("Простоквашино", 100, 0, RUSSIA, Milk.MilkType.MILK, 2.5), 100)
                .addProducts(new Milk("Простоквашино", 110, 0, RUSSIA, Milk.MilkType.KEFIR, 2.5), 100)
                .addProducts(new Milk("Простоквашино", 215, 0, RUSSIA, Milk.MilkType.COTTAGE_CHEESE, 9)
                        , 30)
                .addProducts(new Milk("Брест-литовск", 110, 0, BELARUS, Milk.MilkType.KEFIR, 2.5), 50)
                .addProducts(new Milk("Брест-литовск", 215, 0, BELARUS, Milk.MilkType.COTTAGE_CHEESE,
                                9),
                        20)
                .addProducts(new Meat("Мираторг", 250, 0, RUSSIA, Meat.MeatType.BEEF, true), 100)
                .addProducts(new Meat("Мираторг", 450, 0, RUSSIA, Meat.MeatType.BEEF, false), 100)
                .addProducts(new Bread("Кирпич", 45, 0, RUSSIA, true, true, false), 100)
                .addProducts(new Bread("Подмосковный", 38, 0, RUSSIA, false, false, false), 150)
                .addProducts(new Bread("Нарезной", 40, 0, RUSSIA, false, false, false), 150)
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
        if (this.reservation.containsKey(product)) {
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

    // отобразить перечень Типов Продукции
    public void showProductsType() {
        this.products.entrySet()
                .stream()
                .map(v -> v.getKey()
                        .getType())
                .distinct()
                .sorted()
                .forEach(v -> System.out.println(v));
    }

    // отобразить перечень уникальных параметров для конкретного Вида Продукции
    public boolean showUniqueProductParams(String productType) {
        for (Map.Entry<Product, Integer> productIntegerEntry : this.products.entrySet()) {
            if (productIntegerEntry.getKey()
                    .getType()
                    .equals(productType)) {
                productIntegerEntry.getKey()
                        .showUniqueProductParameter();
                return true;
            }
        }
        System.out.println("Указанный вами вид продуции отсутствует на данный момент.");
        return false;
    }

    // отобразить перечень Продукции конкретного типа
    public void showProducts(String productType) {
        this.products.entrySet()
                .stream()
                .filter(v ->
                        v.getKey()
                                .getType()
                                .equals(productType)
                )
                .forEach(v -> System.out.println(v.getKey()));
    }

    // отбор Продукта по параметрам, указанным Покупателем
    public Product getProductByParams(String[] params) {
        for (Map.Entry<Product, Integer> productIntegerEntry : this.products.entrySet()) {
            if(productIntegerEntry.getKey().checkProductParams(params)){
                return productIntegerEntry.getKey();
            }
        }
        throw new RuntimeException("Не удалось найти Продукцию, соответствующую заданным параметрам.");
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
