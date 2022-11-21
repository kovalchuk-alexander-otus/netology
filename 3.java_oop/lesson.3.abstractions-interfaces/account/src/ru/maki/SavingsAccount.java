package ru.maki;

// Сберегательный счет
//
// Со сберегательного счета нельзя платить, только переводить и пополнять.
// Также сберегательный не может уходить в минус.
public class SavingsAccount extends Account{
    public SavingsAccount(String code) {
        super(code);
    }

    @Override
    public void pay(int amount) {
        super.pay(amount);
        System.out.println("Операция отклонена - со сберегательного счета нельзя " +
                                   "платить");
    }

    @Override
    public void transfer(Account account, int amount) {
        super.transfer(account, amount);
    }

    @Override
    public void addMoney(int amount) {
        super.addMoney(amount);
        this.balance += amount;
        System.out.printf("Пополнение счета на сумму %d успешно произведено %n%n", amount);
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "balance=" + balance +
                '}';
    }
}
