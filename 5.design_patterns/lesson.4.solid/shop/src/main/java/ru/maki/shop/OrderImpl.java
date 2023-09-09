package ru.maki.shop;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class OrderImpl implements Order {
    Product product;
    DeliveryInfo deliveryInfo;
    PayInfo payInfo;
    RateInfo rateInfo;

    @AllArgsConstructor
    @ToString
    class DeliveryInfo {
        String city;
        String street;
        int house;
        int apartment;
    }

    @AllArgsConstructor
    @ToString
    class PayInfo {
        String card;
        int pin;
    }

    @AllArgsConstructor
    @ToString
    class RateInfo {
        int rate;
        String review;
    }

    @Override
    public void product(String type, String name, int price, int count) {
        this.product = new Product(ProductType.valueOf(type), name, price, 0, count);
    }

    @Override
    public void delivery(String city, String street, int house, int apartment) {
        this.deliveryInfo = new DeliveryInfo(city, street, house, apartment);
    }

    @Override
    public void pay(String card, int pin) {
        this.payInfo = new PayInfo(card, pin);
    }

    @Override
    public void rate(int rate, String review) {
        this.rateInfo = new RateInfo(rate, review);
    }

    public void complete() {
        Shop shop = Shop.getInstance();
        if (shop.buy(this)) Shopping.orders.add(this);
    }
}
