package ru.maki;

public abstract class Account {
    protected long balance;

    public Account(long balance) {
        this.balance = balance;
    }

    // пополнение счёта на amount, возвращает true, если пополнение успешно, и false, если иначе
    public abstract boolean add(long amount);

    // покупка со счёта на amount, возвращает true, если пополнение успешно, и false, если иначе
    public abstract boolean pay(long amount);

    // перевод денег со счёта, у которого был вызван метод, на счёт из параметра на сумму в размере amount,
    // возвращает true, если пополнение успешно, и false, если иначе
    public boolean transfer(Account account, long amount) {
        if (this.pay(amount)) {
            if (account.add(amount)) {
                return true;
            } else {
                this.pay(-amount);
            }
        }
        return false;
    }

    // текущий баланс на счёте
    public long getBalance() {
        return this.balance;
    }
}
