package ru.maki.shop;

import ru.maki.client.Client;

import java.text.SimpleDateFormat;

public class Order {
    private Cart cart;
    private Client client; // TODO: Client: ФИО, Contacts.Phone, Contacts.Mail, Адрес
    private DeliveryMethod deliveryMethod; // способ доставки (самовывоз/доставка)
    private Address address; // TODO: Address: город, улица, дом, квартира
    private List<Contacts> contacts; // TODO: Contacts + Phone: makeCall & TODO: Contacts + Mail: sendMessage
    private Office office; // TODO: Office: при инициации магазина, заполнять List с офисами; имя, Address
    private SimpleDateFormat deliveryTime; // TODO: время доставки
    private PaymentMethod paymentMethod; // способ оплаты (картой/наличными)

    // TODO: Builder
// • использовать шаблон builder для оформления заказа по-шагам (ФИО, телефон, почта + самовывоз/доставка + офис | адрес, дата -> метод оплаты картой)
//            • метод оплаты реализовать в классе Заказ .. в момент оплаты, бронь снимается и продукты на складе уменьшаются
}
