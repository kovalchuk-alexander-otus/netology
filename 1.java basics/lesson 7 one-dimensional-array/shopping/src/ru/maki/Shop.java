package ru.maki;

import java.util.Scanner;

public class Shop {
    private final int PRODUCT_ID = 0; // индекс id продукта
    private final int PRODUCT_COUNT = 1; // индекс количества продукта

    private Product[] products; // список товаров с ценами

    public Shop(Product[] products) {
        this.products = products;
    }

    public Product[] getProducts() {
        return products;
    }

    // демонстрация витрины магазина - список товар+цена
    private void showcase() {
        System.out.println("Список возможных товаров для покупки:");
        for (int i = 0; i < this.products.length; i++) {
            System.out.printf("%3s.%-11s%7.2f\tруб./шт. \n"
                    , i + 1
                    , this.products[i].getName()
                    , this.products[i].getPrice());
        }
    }

    // интерфейс - процесс покупки
    public Cart makeShopping() {
        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart(this.products);
        while (true) {
            showcase();
            System.out.print("Введите id товара и количество через пробел или введите 'end'\n > ");
            String buffer = scanner.nextLine();

            if ("end".equals(buffer)) break;

            try {
                String[] s = buffer.split(" ");
                int productId = Integer.parseInt(s[PRODUCT_ID]) - 1;
                int productCount = Integer.parseInt(s[PRODUCT_COUNT]);
                cart.putProductIntoCart(productId, productCount);
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели некорректное значение. Попробуйте еще один раз.\n\n");
            }

        }
        scanner.close();
        return cart;
    }


}
