package ru.maki;

// обычный Счёт
public class SimpleAccount extends Account {

    public SimpleAccount(long balance) {
        super(balance);
    }

    // можно пополнять сколько угодно раз
    @Override
    public boolean add(long amount) {
        this.balance += amount;
        return true;
    }

    // можно платить, пока на Счёте есть деньги
    @Override
    public boolean pay(long amount) {
        if (this.balance > amount) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

}
