package ru.maki.shop;

import ru.maki.client.Address;
import ru.maki.client.Client;
import ru.maki.client.Contact;

import java.text.SimpleDateFormat;
import java.util.List;

public class Order {
    private Cart cart;
    private Client client; // Client: ФИО, Contacts.Phone, Contacts.Mail, Адрес (...если Клиент ранее регистрировался)
    private DeliveryMethod deliveryMethod; // способ доставки (самовывоз/доставка)
    private Address address; // Address: город, улица, дом, квартира (заполняется если заказана доставка)
    private List<Contact> contacts; // Contacts + Phone & Contacts + Mail
    private Office office; // Office: имя, Address (заполняется если выбран самовывоз)
    private SimpleDateFormat deliveryTime; // время доставки
    private PaymentMethod paymentMethod; // способ оплаты (картой/наличными)

    // TODO: Builder
// • использовать шаблон builder для оформления заказа по-шагам (ФИО, телефон, почта + самовывоз/доставка + офис | адрес, дата -> метод оплаты картой)
//            • метод оплаты реализовать в классе Заказ .. в момент оплаты, бронь снимается и продукты на складе уменьшаются
}
