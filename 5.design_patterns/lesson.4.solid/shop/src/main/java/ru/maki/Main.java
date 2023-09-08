package ru.maki;

// TODO: SOLID.Single Responsibility Principle
// TODO: SOLID.Open Closed Principle
// TODO: SOLID.Liskov Substitution Principle
// TODO: SOLID.Interface Segregation Principle
// TODO: SOLID.Dependency Inversion Principle

import ru.maki.shop.Product;
import ru.maki.shop.ProductType;
import ru.maki.shop.Shop;
import ru.maki.utils.Logger;

public class Main {
    public static void main(String[] args) {
        Product product = new Product(ProductType.PRODUCTS, "кефир", 100, 9);
        System.out.println(product);

        Logger logger = Logger.getInstance();
        logger.log("запуск программы 'Магазин'");

        Shop shop = new Shop();
        shop.load();

    }
}