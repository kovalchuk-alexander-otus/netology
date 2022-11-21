package ru.maki;

// Расчетный счет.
//
// Расчетный может выполнять все три операции, но не может уходить в минус.
public class CheckingAccount extends Account {
    public CheckingAccount(String code) {
        super(code);
    }

    @Override
    public void pay(int amount) {
        super.pay(amount);
        if (checkRest(amount)) {
            this.balance -= amount;
            System.out.printf("Успешно списано %d%n%n", amount);
        }
    }

    @Override
    public void transfer(Account account, int amount) {
        super.transfer(account, amount);
    }

    @Override
    public void addMoney(int amount) {
        super.addMoney(amount);
        System.out.printf("Счет пополнен на сумму %d%n%n", amount);
        this.balance += amount;
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "balance=" + balance +
                '}';
    }
}
