package ru.maki.shop;

import lombok.Getter;
import ru.maki.Env;
import ru.maki.utils.Formatter;
import ru.maki.utils.Logger;
import ru.maki.utils.SimpleFile;

import java.time.LocalDateTime;
import java.util.List;


// Это финальная задача! В этом задании попрактикуемся с правилами чистого кода и принципами SOLID.
//
//Нужно написать программу-магазин, в которой пользователи заказывают товары. Вам предоставляется свобода в продумывании функциональности вашей программы, как и в проектировании её структуры. В процессе реализации вы должны применить принцип избегания магических чисел, DRY и как минимум 4 из 5 принципов SOLID, причём явно комментариями в коде или при отправке решения указать по одному примеру применения каждого принципа в вашем решении со ссылками на конкретные места кода на гитхабе.
//
//Примеры возможностей программы:
//
//TODO: Вывод доступных для покупки товаров
//TODO: Фильтрация товаров по ключевым словам, ценам, производителям
//TODO: Составление продуктовой корзины пользователя
//TODO: Трекинг заказа в системе доставки
//TODO: Возврат заказа, повтороение заказа
//TODO: Система рейтинга для товаров
//TODO: Простая рекомендательная система для покупок

//
// Склад -> наличие товаров
// Товар
// Заказ
//
public class Shop implements ProductsLoader, Schowcase, Purchase {
    Logger logger = Logger.getInstance();
    @Getter
    List<Product> productList;
    private static Shop instance;

    public Shop() {
        this.productList = this.load();
    }

    public static Shop getInstance() {
        if (instance == null) instance = new Shop();
        return instance;
    }

    @Override
    public List<Product> load() {
        String data;

        // читаем из файла в строку
        data = SimpleFile.read(Env.SOURCE, Env.CHARSET_UTF8);

        // варим список объектов
        Formatter formatter = new Formatter<>(Product.class);
        List<Product> products = formatter.jsonToList(data);

        return products;
    }

    /**
     * Загрузка новых товаров на витрину
     */
    @Override
    public void delivery() {
        String data;
        logger.log("Загрузка новых товаров на витрину");

        // читаем из файла в строку
        data = SimpleFile.read(this.getDeliverySourceName(), Env.CHARSET_UTF8);

        // варим список объектов
        Formatter formatter = new Formatter<>(Product.class);
        List<Product> productsDelivery = formatter.jsonToList(data);

        for (Product productDelivery : productsDelivery) {
            ProductType productType = productDelivery.getProductType();
            String productName = productDelivery.getName();
            int productInStock = productDelivery.getInStock();
            boolean flag = true;
            for (Product product : this.productList) {
                if (product.getProductType().equals(productType) && product.getName().equals(productName)) {
                    logger.log(String.format("..пополнили число продукции [%s : %s] на %d шт.", productType, productName, productInStock));
                    product.setInStock(product.getInStock() + productInStock);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                logger.log(String.format("..загрузка продукта [%s : %s] в количестве %d шт., ранее отсутствовавшего на витрине", productType, productName, productInStock));
                this.productList.add(productDelivery);
            }
        }

        logger.log("Загрузка продукции на витрину завершена.");
    }

    /**
     * получение имени источника, содержащего информацию о поставке товара на сегодня
     *
     * @return
     */
    public String getDeliverySourceName() {
        return String.format(Env.DELIVERY, LocalDateTime.now().format(Env.dateFormatter));
    }

    /**
     * запись текущего состояния витрины в файл
     */
    @Override
    public void unload() {
        Formatter<Product> formatter = new Formatter(Product.class);
        SimpleFile.write(formatter.listToJson(productList), Env.SOURCE, Env.CHARSET_UTF8);
    }

    @Override
    public void show() {
        this.show(null, 0, 0);
    }

    @Override
    public void show(ProductType productType) {
        this.show(productType, 0, 0);
    }

    @Override
    public void show(ProductType productType, int rate) {
        this.show(productType, 0, rate);
    }

    @Override
    public void show(ProductType productType, int price, int rate) {
        System.out.println("\n\nВитрина магазина:");
        for (Product product : productList) {
            if ((productType == null || product.getProductType().equals(productType)) &&
                    (price == 0 || product.getPrice() <= price) &&
                    (rate == 0 || product.getRate() >= rate))
                System.out.println(product);
        }
    }

    @Override
    public boolean buy(Order order) {
        Product prod = ((OrderImpl) order).getProduct();
        for (Product product : productList) {
            if (product.getProductType().equals(prod.getProductType()) && product.getName().equals(prod.getName())) {
                if (product.getInStock() >= prod.getInStock()) {
                    product.setInStock(product.getInStock() - prod.getInStock());
                    return true;
                } else return false;
            }
        }
        return false;
    }
}
