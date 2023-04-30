package ru.maki.shop;

import ru.maki.product.Product;

import java.util.HashMap;
import java.util.Map;

// Корзина покупателя
public class Cart {

    private Map<Product, Integer> products = new HashMap<>(); // корзина Покупателя - продукты и количество

    // добавление продукта в корзину Покупателя
    public void addProduct(Product product, int number) {
        Stock stock = Stock.get();
        int available = stock
                .availableNumberOfProduct(product);
        // проверить наличие продукта в нужном количестве
        if (number > available) {
            System.out.printf("На складе доступно для бронирования [%d] %s что недостаточно.%n", available, product);
        } else {
            // забронировать его на Складе
            stock.makeReservation(product, number);
            // добавить в корзину
            if (this.products.containsKey(product)) {
                this.products.put(product, this.products.get(product) + number);
            } else {
                this.products.put(product, number);
            }
        }
    }

    // удаление Продукта из корзины покупателя
    public void removeProduct(Product product) {
        // проверяем наличие Продукта в корзине и в каком количестве
        if (this.products.containsKey(product)) {
            int number = this.products.get(product);
            // снимаем бронь по Продукту в высвобождаемом количестве
            Stock.get()
                    .canselReservation(product, number);
            // удаляем Продукт из корзины ...
            this.products.remove(product);
        }
    }

    public void printProducts(String message) {
        System.out.println(message);
        for (Map.Entry<Product, Integer> productIntegerEntry : this.products.entrySet()) {
            System.out.printf("[%3d] %s%n", productIntegerEntry.getValue(), productIntegerEntry.getKey());
        }
    }

    @Override
    public String toString() {
        return "Cart{" +
                "products=" + products +
                '}';
    }
}
