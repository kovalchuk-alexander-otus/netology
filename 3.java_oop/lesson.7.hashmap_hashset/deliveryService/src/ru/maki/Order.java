package ru.maki;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Order {
    private final Map<Address, BigDecimal> listOfOrders; // список адресов доставки с Весом
    private final Map<Address, BigDecimal> availableAddress; // список доступных адресов доставки (со стоимостью 1 кг)
    private BigDecimal fullPrice; // полная стоимость заказа
    private final Set<String> countrys; // уникальный список стран доставки в Заказе

    public Order(Map<Address, BigDecimal> availableAddress) {
        this.listOfOrders = new HashMap<>();
        this.availableAddress = availableAddress;
        this.fullPrice = new BigDecimal("0");
        this.countrys = new HashSet<>();
    }

    public void setCountry(String country) {
        this.countrys.add(country);
    }

    public void setFullPrice(BigDecimal price) {
        this.fullPrice = this.fullPrice.add(price);
    }

    public BigDecimal getFullPrice() {
        return this.fullPrice;
    }

    public void setListOfOrders(Address address, BigDecimal weight) {
        BigDecimal currentWeight = this.listOfOrders.get(address);
        this.listOfOrders.put(address, currentWeight == null ? weight : currentWeight.add(weight));
    }

    public Map<Address, BigDecimal> getListOfOrders() {
        return listOfOrders;
    }

    // добавление Адреса доставки в Заказ
    //  со всеми проверками и попутными сохранениями
    public BigDecimal addOrder(Address address, BigDecimal weight) {
        // проверка доступности адреса доставки
        if (this.availableAddress.containsKey(address)) {
            // учтем страну в списке стран, куда осуществляем доставку
            setCountry(address.getCountry());
            // заполнение списка адресов Заказа
            setListOfOrders(address, weight);
            // расчет стоимости доставки
            BigDecimal priceOrder = this.availableAddress.get(address)
                    .multiply(weight);
            // заполнение полной стоимости Заказа
            setFullPrice(priceOrder);
            return priceOrder;
        } else {
            return null;
        }
    }

    public void showCountCountry() {
        System.out.printf("%nЧисло стран доставки: %d", this.countrys.size());
    }
}
