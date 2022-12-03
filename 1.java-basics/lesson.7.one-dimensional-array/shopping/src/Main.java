import ru.maki.Cart;
import ru.maki.Product;
import ru.maki.Shop;

public class Main {
    public static void main(String[] args) {

        // загрузка витрины магазина
        Shop shop = new Shop(new Product[]{new Product("творог", 230.0)
                , new Product("кефир", 89.50)
                , new Product("ряженка", 101.75)
                , new Product("сыр", 165.0)
                , new Product("сметана", 78.0)});

        // процесс покупки
        Cart cart = shop.makeShopping();

        // отобразим корзину
        cart.showShoppingCart(shop);

    }

}