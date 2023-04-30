package ru.maki.shop;

import ru.maki.client.Address;
import ru.maki.client.Client;
import ru.maki.client.Contact;
import ru.maki.client.ContactsType;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

public interface OrderBuilder {
    // подтверждение перечня продуктов в заказе
    OrderBuilder setCart(Cart cart);

    // заведение Клиента с нуля
    OrderBuilder setClient(Client client);

    // заведение Клиента путем поиска среди зарегистрированных ранее в программе
    OrderBuilder setClient(String login);

    // заведение информации о доставке (доставка на дом)
    OrderBuilder setDeliveryInfo(Address address, Map<ContactsType, Contact> contacts, Calendar deliveryTime);

    // заведение информации о доставке (самовывоз из офиса магазина)
    OrderBuilder setDeliveryInfo(Office office, Calendar deliveryTime);

    // заведение информации о способе оплаты
    OrderBuilder setPaymentInfo(PaymentMethod paymentMethod);

    // формирование заказа
    Order build(DeliveryMethod deliveryMethod);
}
