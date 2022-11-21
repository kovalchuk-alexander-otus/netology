package ru.maki;

// Кредитный счет
//
// Кредитный не может иметь положительный баланс – если платить с него, то уходит в
// минус, чтобы вернуть в 0, надо пополнить его.
public class CreditAccount extends Account {
    public CreditAccount(String code) {
        super(code);
    }

    // попробуем перегрузить метод и посмотрим что из этого выйдет
    @Override
    protected boolean checkRest(int amount) {
        return true;
    }

    @Override
    public void pay(int amount) {
        super.pay(amount);
        this.balance -= amount;
        System.out.printf("Платеж/списание на сумму %d успешно совершен(о).", amount);
    }

    @Override
    public void transfer(Account account, int amount) {
        super.transfer(account, amount);
    }

    @Override
    public void addMoney(int amount) {
        super.addMoney(amount);
        if (this.balance + amount > 0) {
            System.out.println("Операция не возможна - остаток по кредиту уходит в +");
            throw new RuntimeException("Операция не возможна - остаток по кредиту уходит в +");
        } else {
            this.balance += amount;
            System.out.println("Операция пополнения успешно завершена");
        }
    }

    @Override
    public String toString() {
        return "CreditAccount{" +
                "balance=" + balance +
                '}';
    }
}
