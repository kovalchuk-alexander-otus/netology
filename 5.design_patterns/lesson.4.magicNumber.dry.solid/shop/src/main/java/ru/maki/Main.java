package ru.maki;

import ru.maki.product.Bread;
import ru.maki.product.Meat;
import ru.maki.product.Product;
import ru.maki.shop.Stock;

public class Main {
    public static void main(String[] args) {

        Stock.init();

        Stock.get()
                .addProducts(new Meat("Мираторг", 200, 0, Product.Country.RUSSIA, Meat.MeatType.LAMB, true), 100)
                .addProducts(new Meat("Мираторг", 200, 0, Product.Country.RUSSIA, Meat.MeatType.PORK, true), 100)
                .addProducts(new Bread("Зерновик", 75, 0, Product.Country.RUSSIA, false, false, true), 50)
                .addProducts(new Meat("Мираторг", 250, 0, Product.Country.RUSSIA, Meat.MeatType.BEEF, true), 50)
                .addProducts(new Meat("Мираторг", 450, 0, Product.Country.RUSSIA, Meat.MeatType.BEEF, false), 10)
                .printGoodsInStock("Склад обновлен..");


        // наполнение Корзины

        // прохождение процедуры оформления Заказа

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