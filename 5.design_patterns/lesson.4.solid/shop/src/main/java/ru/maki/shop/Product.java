package ru.maki.shop;

public class Product {
    ProductType productType;
    String name;
    int price;
    int rate;

    public Product(ProductType productType, String name, int price, int rate) {
        this.productType = productType;
        this.name = name;
        this.price = price;
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productType=" + productType +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", rate=" + rate +
                '}';
    }
}
