package ru.maki;

import ru.maki.product.Bread;
import ru.maki.product.Meat;
import ru.maki.product.Product;
import ru.maki.shop.Stock;

import java.util.Arrays;
import java.util.Scanner;

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
        String input;
        try(Scanner scanner = new Scanner(System.in)){
            while (true){
                System.out.println("Выберите \"Раздел каталога\"");
                Stock.get().showProductsType(); // выберите Раздел каталога
                input = scanner.nextLine();

                if(Stock.get().showUniqueProductParams(input)){
                    System.out.println("Выберите \"Продукт\"");
                    Stock.get().showProducts(input); // выберите Продукт
                    String[] params = scanner.nextLine().split(" ");
                    System.out.println(Arrays.toString(params));

                    try{
                        Product product = Stock.get()
                                .getProductByParams(params);
                        System.out.println(product);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                System.out.println("В случае, если вы закончили выбор Продукции - введите \"end\".");
                input = scanner.nextLine();
                if(input.equals("end")){
                    break;
                }
            }
        }
        // ..оформления Заказа

        // трекинг Заказа и его контроль

        //


        // TODO: проектирование магазина
        //  товар (рейтинг - свойство)
        //+      молочка (тип..молоко,кефир,творог,сыр,сметана,ряженка,масло; % жирности)
        //+    , мясо (тип..свинина/говядина/баранина/птица, фарш..признак)
        //+    , хлеб (белый/черный, ржаной/пшеничный, бездрожжевой/дрожжевой)
        //-    , овощи-фрукты (сезонные, сорт)
        //+  склад -> товар (HashMap - товар, количество)
        //     реализовать сортировку при выводе мапы на экран
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