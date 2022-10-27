package ru.maki;

public class Cart {
    private int[] shoppingCart; // корзина покупателя

    public Cart(Product[] products) {
        this.shoppingCart = new int[products.length];
    }

    // помещаем товар в указанном Клиентом количестве в корзину
    public void putProductIntoCart(int productId, int productCount) {
        this.shoppingCart[productId] += productCount;
    }

    // демонстрация корзины
    public void showShoppingCart(Shop shop) {
        System.out.println("\n\nВаша корзина:");
        // System.out.println(Arrays.toString(shoppingCart));
        System.out.println("Наименование товара   Количество  Цена/за.ед  Общая стоимость");
        double fullPrice = 0;
        for (int i = 0; i < this.shoppingCart.length; i++) {
            if (this.shoppingCart[i] != 0) {
                System.out.printf("%-22s%-12s%12.2f%15.2f\n",
                        shop.getProducts()[i].getName(), shoppingCart[i], shop.getProducts()[i].getPrice(),
                        shoppingCart[i] * shop.getProducts()[i].getPrice());
                fullPrice += shoppingCart[i] * shop.getProducts()[i].getPrice();
            }
        }
        System.out.printf("\n%22s %.2f \n", "Итого:", fullPrice);
    }
}
