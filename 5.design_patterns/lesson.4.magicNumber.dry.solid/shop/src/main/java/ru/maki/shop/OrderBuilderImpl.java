package ru.maki.shop;

import ru.maki.client.Address;
import ru.maki.client.Client;
import ru.maki.client.Contact;
import ru.maki.client.ContactsType;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class OrderBuilderImpl implements OrderBuilder{
    Scanner scanner = new Scanner(System.in);
    private Cart cart; // корзина Покупателя
    private Client client; // Client: ФИО, Contacts.Phone, Contacts.Mail, Адрес (...если Клиент ранее регистрировался)
    private DeliveryMethod deliveryMethod; // способ доставки (самовывоз/доставка)
    private Address address; // Address: город, улица, дом, квартира (заполняется если заказана доставка)
    private Map<ContactsType, Contact> contacts; // Contacts + Phone & Contacts + Mail
    private Office office; // Office: имя, Address (заполняется если выбран самовывоз)
    private Calendar deliveryTime; // время доставки
    private PaymentMethod paymentMethod; // способ оплаты (картой/наличными)
    @Override
    public OrderBuilder setCart(Cart cart) {
        cart.printProducts("Стадия подтверждения заказа..");
        this.cart = cart;
        return this;
    }

    @Override
    public OrderBuilder setClient(Client client) {
        this.client = client;
        return this;
    }

    @Override
    public OrderBuilder setClient(String login) {
        // TODO: требуется реализация, которая по login будет пытаться найти в базе Клиента
        return this;
    }

    @Override
    public OrderBuilder setDeliveryInfo(Address address, Map<ContactsType, Contact> contacts, Calendar deliveryTime) {
        this.deliveryMethod = DeliveryMethod.DELIVERY;
        this.address = address;
        this.contacts = contacts;
        this.deliveryTime = deliveryTime;
        return this;
    }

    @Override
    public OrderBuilder setDeliveryInfo(Office office, Calendar deliveryTime) {
        this.deliveryMethod = DeliveryMethod.PICKUP;
        // TODO: требуется реализовать метод для случая доставки в Офис
        return this;
    }

    @Override
    public OrderBuilder setPaymentInfo(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    @Override
    public Order build(DeliveryMethod deliveryMethod) {
        // TODO: требуется зафиксировать, что произошло оформление заказа
        //   а это значит, что товар должен уменьшиться на складе
        //   а заказ должен попасть в очередь обработки
        if (deliveryMethod == DeliveryMethod.DELIVERY){
            return new Order(cart, client, deliveryMethod, address, contacts,
                    deliveryTime, paymentMethod);
        } else {
            return new Order(cart, client, deliveryMethod, office,
                    deliveryTime, paymentMethod);
        }
    }

    @Override
    public String toString() {
        return "OrderBuilderImpl{" +
                "scanner=" + scanner +
                ", cart=" + cart +
                ", client=" + client +
                ", deliveryMethod=" + deliveryMethod +
                ", address=" + address +
                ", contacts=" + contacts +
                ", office=" + office +
                ", deliveryTime=" + deliveryTime +
                ", paymentMethod=" + paymentMethod +
                '}';
    }
}
