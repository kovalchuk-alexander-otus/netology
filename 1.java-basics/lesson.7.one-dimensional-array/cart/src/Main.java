import ru.maki.Cart;
import ru.maki.Shop;

public class Main {
    public static void main(String[] args) {
        // инициируем Магаз
        Shop shop = new Shop(new String[]{"Молоко", "Кефир", "Ряженка", "Творог"}, new int[]{84, 108, 115, 230});

        shop.showShop();

        // инициируем Корзину
        Cart cart = new Cart(shop.getProducts().length);
        cart.shopping();
        cart.showCart(shop);
    }
}