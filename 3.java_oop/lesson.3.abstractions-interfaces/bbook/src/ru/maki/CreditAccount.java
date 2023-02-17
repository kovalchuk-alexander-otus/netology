package ru.maki;

// кредитный Счёт
public class CreditAccount extends Account {

    protected final long limit; // кредитный лимит, установленный на Счёте

    public CreditAccount(long balance, long limit) {
        super(balance);
        this.limit = limit;
    }

    // не может уходить в плюс
    @Override
    public boolean add(long amount) {
        if (this.balance + amount <= 0) {
            this.balance += amount;
            return true;
        }
        return false;
    }

    // может уходить в минус до кредитного лимита, указанного в конструкторе
    @Override
    public boolean pay(long amount) {
        if (Math.abs(this.limit) >= Math.abs(this.balance - amount)) {
            this.balance -= amount;
            return true;
        }
        return false;
    }
}
