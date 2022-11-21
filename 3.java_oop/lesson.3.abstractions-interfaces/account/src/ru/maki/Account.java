package ru.maki;

public abstract class Account {

    protected String code;
    protected int balance;

    public Account(String code) {
        this.code = code;
        this.balance = 0;
    }

    protected boolean checkRest(int amount) {
        if (this.balance - amount < 0) {
            System.out.printf("Недостаточно средств на счете.\n");
            return false;
        }
        return true;
    }

    void pay(int amount){
        System.out.println("\n\n------------------------------------------------------");
        System.out.println(" ПЛАТЕЖ");
        System.out.println(this.code);
    }


    protected void transfer(Account account, int amount) {
        System.out.println("\n\n------------------------------------------------------");
        System.out.println(" ПЕРЕВОД");
        System.out.printf("[%s] - [%s] %d%n", this.code, account.code, amount);
        if (checkRest(amount)) {
            if (account instanceof SavingsAccount) {
                System.out.println("saving");
                this.balance -= amount;
                account.balance += amount;
                System.out.printf("Счет %s успешно пополнен на сумму %d%n%n",
                                  account.code, amount);
            }
            if (account instanceof CreditAccount) {
                System.out.println("credit");
                if (account.balance + amount > 0) {
                    System.out.println("Операция невозможна - остаток по кредиту уходит в +");
                    System.out.printf("Попытка перевести %d с %s на %s%n%n", amount, this.code,
                                      account.code);
                } else {
                    this.balance -= amount;
                    account.balance += amount;
                    System.out.printf("Счет %s успешно пополнен на сумму %d%n%n",
                                      account.code, amount);
                }
            }
            if (account instanceof CheckingAccount) {
                System.out.println("checking");
                this.balance -= amount;
                account.balance += amount;
                System.out.printf("Счет %s успешно пополнен на сумму %d%n%n",
                                  account.code, amount);
            }
        } else System.out.printf("Попытка перевести %d с %s на %s%n%n", amount, this.code,
                                 account.code);
    }

    void addMoney(int amount){
        System.out.println("\n\n------------------------------------------------------");
        System.out.println(" ПОПОЛНЕНИЕ");
        System.out.println(this.code);
    }
}
