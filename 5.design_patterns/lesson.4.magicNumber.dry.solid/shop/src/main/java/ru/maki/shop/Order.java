package ru.maki.shop;

import ru.maki.client.Address;
import ru.maki.client.Client;
import ru.maki.client.Contact;
import ru.maki.client.ContactsType;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class Order {
    private Cart cart;
    private Client client; // Client: ФИО, Contacts.Phone, Contacts.Mail, Адрес (...если Клиент ранее регистрировался)
    private DeliveryMethod deliveryMethod; // способ доставки (самовывоз/доставка)
    private Address address; // Address: город, улица, дом, квартира (заполняется если заказана доставка)
    private Map<ContactsType, Contact> contacts; // Contacts + Phone & Contacts + Mail
    private Office office; // Office: имя, Address (заполняется если выбран самовывоз)
    private Calendar deliveryTime; // время доставки
    private PaymentMethod paymentMethod; // способ оплаты (картой/наличными)

    public Order(Cart cart, Client client, DeliveryMethod deliveryMethod, Address address, Map<ContactsType, Contact> contacts, Calendar deliveryTime, PaymentMethod paymentMethod) {
        this.cart = cart;
        this.client = client;
        this.deliveryMethod = deliveryMethod;
        this.address = address;
        this.contacts = contacts;
        this.deliveryTime = deliveryTime;
        this.paymentMethod = paymentMethod;
    }
    public Order(Cart cart, Client client, DeliveryMethod deliveryMethod, Office office, Calendar deliveryTime, PaymentMethod paymentMethod) {
        this.cart = cart;
        this.client = client;
        this.deliveryMethod = deliveryMethod;
        this.office = office;
        this.deliveryTime = deliveryTime;
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Order{" +
                "cart=" + cart +
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
