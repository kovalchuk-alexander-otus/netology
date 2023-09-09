package ru.maki.shop;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private ProductType productType;
    private String name;
    private int price;
    private int rate;
    private int inStock;

    public Product(ProductType productType, String name, int price, int rate, int inStock) {
        this.productType = productType;
        this.name = name;
        this.price = price;
        this.rate = rate;
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productType=" + productType +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", rate=" + rate +
                ", inStock=" + inStock +
                '}';
    }
}
