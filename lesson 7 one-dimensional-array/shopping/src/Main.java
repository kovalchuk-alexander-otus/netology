import ru.maki.Shop;

public class Main {
    public static void main(String[] args) {

        Shop shop = new Shop(new String[]{"творог", "кефир", "ряженка", "сыр", "сметана"});
        shop.setPrice();
        shop.makeShopping();
        shop.showShoppingCart();

    }

}