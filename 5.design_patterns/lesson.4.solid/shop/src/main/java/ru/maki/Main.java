package ru.maki;

// TODO: SOLID.Open Closed Principle
// TODO: SOLID.Liskov Substitution Principle
// TODO: SOLID.Interface Segregation Principle
// TODO: SOLID.Dependency Inversion Principle

import ru.maki.shop.*;
import ru.maki.utils.Formatter;
import ru.maki.utils.Logger;
import ru.maki.utils.SimpleFile;

public class Main {
    public static void main(String[] args) {
        Product product = new Product(ProductType.PRODUCTS, "кефир", 100, 9, 300);
        System.out.println(product);

        Logger logger = Logger.getInstance();
        logger.log("Запуск программы 'Магазин'");

        Shop shop = Shop.getInstance();
        shop.show();
        shop.show(ProductType.TECHNOLOGY);
        shop.show(ProductType.TECHNOLOGY, 15000, 0);

        Formatter<Product> formatter = new Formatter(Product.class);
        SimpleFile.write(formatter.listToJson(shop.getProductList()), shop.getDeliverySourceName(), Env.CHARSET_UTF8);

        // блок частных закупок товаров
        Order order1 = new OrderImpl();
        ((OrderImpl) order1).product(ProductType.PRODUCTS.name(), "Кефир", 100, 323);
        ((OrderImpl) order1).delivery("Москва", "Кантима", 10, 232);
        ((OrderImpl) order1).pay("2342 4234 4232 4234", 343);
        ((OrderImpl) order1).rate(10, "нормальненько так все");
        ((OrderImpl) order1).complete();
        Order order2 = new OrderImpl();
        ((OrderImpl) order2).product(ProductType.PRODUCTS.name(), "Молоко", 100, 123);
        ((OrderImpl) order2).delivery("Москва", "Кантима", 10, 232);
        ((OrderImpl) order2).pay("2342 4234 4232 4234", 343);
        ((OrderImpl) order2).rate(10, "нормальненько так все");
        ((OrderImpl) order2).complete();

        // поглядим чо там у нас
        Shopping.show();

        shop.show();
        shop.delivery();
        shop.show();

        shop.unload();

    }
}