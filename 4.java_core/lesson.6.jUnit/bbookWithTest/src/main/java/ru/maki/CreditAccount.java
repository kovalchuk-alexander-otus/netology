package ru.maki;

// кредитный Счёт
public class CreditAccount extends Account {

    protected final long limit; // кредитный лимит, установленный на Счёте

    public CreditAccount(long balance, long limit) {
        super(balance);
        if (balance > 0) {
            throw new RuntimeException("Баланс Кредитного счета не может быть больше 0");
        }
        this.limit = limit;
    }

    public long getLimit() {
        return limit;
    }

    // не может уходить в плюс
    @Override
    public boolean add(long amount) {
        if (amount >= 0 & this.balance + amount <= 0) {
            this.balance += amount;
            return true;
        }
        return false;
    }

    // может уходить в минус до кредитного лимита, указанного в конструкторе
    @Override
    public boolean pay(long amount) {
        if (amount >= 0 & Math.abs(this.limit) >= Math.abs(this.balance - amount)) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "CreditAccount{" +
                "limit=" + limit +
                ", balance=" + balance +
                '}';
    }
}
