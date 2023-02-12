package ru.maki;

import java.util.Arrays;

public class Shop {
    final String[] products;
    final int[] price;

    public Shop(String[] products, int[] price) {
        this.products = products;
        this.price = price;
    }

    public String[] getProducts() {
        return products;
    }

    public int[] getPrice() {
        return price;
    }

    public void showShop(){
        for (int i = 0; i < this.products.length; i++) {
            System.out.printf(" %d. %s %d руб/шт%n", (i + 1), products[i], this.price[i]);
        }
    }

    @Override
    public String toString() {
        return "Shop{" +
                "products=" + Arrays.toString(products) +
                ", price=" + Arrays.toString(price) +
                '}';
    }
}
