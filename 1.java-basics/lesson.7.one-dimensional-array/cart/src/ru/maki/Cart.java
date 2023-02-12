package ru.maki;

import java.util.Scanner;

public class Cart {
    final int[] products;
    final int PROD_ID = 0;
    final int PROD_COUNT = 1;

    final Scanner scanner = new Scanner(System.in);

    public Cart(int range) {
        this.products = new int[range];
    }

    public void shopping() {
        String input;
        String[] shop;

        while (true) {
            System.out.print("Выберите товар и количество или введите `end` \n > ");
            input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }

            shop = input.split(" ");

            if (Integer.parseInt(shop[PROD_ID]) > this.products.length) {
                System.out.println("Вы указали несуществующий продукт. Попробуйте еще раз..");
                continue;
                // ??? вот интересно ... IDEA подсказывает, что тут не нужен continue ... но в случае, если его
                // убрать и код будет дорабатываться - есть риск словить ошибку
            } else {
                this.products[Integer.parseInt(shop[PROD_ID]) - 1] += Integer.parseInt(shop[PROD_COUNT]);
            }
        }
    }

    public void showCart(Shop shop) {
        int price;
        int fullPrice = 0;

        System.out.println("Ваша корзина:");
        for (int i = 0; i < this.products.length; i++) {
            if (this.products[i] != 0) {
                // такой продукт в корзине замечен
                price = this.products[i] * shop.getPrice()[i];
                fullPrice += price;
                System.out.printf("%s %d шт %d руб/шт %d руб в сумме %n", shop.getProducts()[i], this.products[i],
                        shop.getPrice()[i], price);
            }
        }
        System.out.printf("Итого %d руб", fullPrice);
    }

}
