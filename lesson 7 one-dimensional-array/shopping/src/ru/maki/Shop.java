package ru.maki;

import java.util.Scanner;

public class Shop {
    private String[] products; // список товаров
    private double[] price; // список цен
    private int[] shoppingCart; // корзина покупателя

    public Shop(String[] products) {
        this.products = products;
        this.price = new double[products.length];
        this.shoppingCart = new int[products.length];
    }

    // загрузка стоимости товаров
    public void setPrice() {
        this.price[0] = 230.0;
        this.price[1] = 89.50;
        this.price[2] = 101.75;
        this.price[3] = 165.0;
        this.price[4] = 78.0;
    }

    // демонстрация витрины магазина - список товар+цена
    private void showcase() {
        System.out.println("Список возможных товаров для покупки:");
        for (int i = 0; i < this.products.length; i++) {
            System.out.printf("%s. %s%s%.2f\tруб./шт. \n"
                    , i + 1
                    , Character.toUpperCase(this.products[i].charAt(0)) + this.products[i].substring(1)
                    , this.products[i].length() / 4 > 0 ? "\t\t" : "\t\t\t"
                    , this.price[i]);
        }
    }

    // интерфейс - процесс покупки
    public void makeShopping() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showcase();
            System.out.print("Введите id товара и количество через пробел или введите 'end'\n > ");
            String buffer = scanner.nextLine();

            if ("end".equals(buffer)) {
                break;
            } else {
                String[] s = buffer.split(" ");
                int productId = Integer.parseInt(s[0]) - 1;
                int productCount = Integer.parseInt(s[1]);
                this.shoppingCart[productId] += productCount;
            }
        }
        scanner.close();
    }

    // демонстрация корзины
    public void showShoppingCart() {
        System.out.println("\n\nВаша корзина:");
        // System.out.println(Arrays.toString(shoppingCart));
        System.out.println("Наименование товара   Количество  Цена/за.ед  Общая стоимость");
        double fullPrice = 0;
        for (int i = 0; i < shoppingCart.length; i++) {
            if (shoppingCart[i] != 0) {
                System.out.printf("%s\t\t\t\t\t%s\t\t%.2f\t\t%.2f\n", products[i], shoppingCart[i], price[i], shoppingCart[i] * price[i]);
                fullPrice += shoppingCart[i] * price[i];
            }
        }
        System.out.printf("\n\t\t\t\t\t\t\t\t\tИтого: %.2f \n", fullPrice);
    }


}
