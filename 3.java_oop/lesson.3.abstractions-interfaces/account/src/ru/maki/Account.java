package ru.maki;

public abstract class Account {

    protected String code;
    protected int    balance;

    public Account(String code) {
        this.code    = code;
        this.balance = 0;
    }

    // контроль достаточности средств
    protected boolean checkRest(int amount) {
        if (this.balance - amount < 0) {
            System.out.println("Недостаточно средств на счете.");
            return false;
        }
        return true;
    }

    // списание со счета
    void pay(int amount) {
        System.out.println("\n\n------------------------------------------------------");
        System.out.println(" ПЛАТЕЖ");
        System.out.println(this.code);
    }


    // перевод средств на другой счет
    protected void transfer(Account account, int amount) {
        System.out.println("\n\n------------------------------------------------------");
        System.out.println(" ПЕРЕВОД");
        System.out.printf("[%s] - [%s] %d%n", this.code, account.code, amount);

        if (this.code.equals(account.code)) {
            System.out.printf("Вы указали один и тот же счет [%s] ..%n%n", this.code);
            return;
        }
        if (checkRest(amount)) {
            try {
                // по своей глубинной сути, трансфер - это набор из двух методов..
                //   порядок именно такой, потому как ... возможность списания мы
                //   проверяем сразу ... но не следует списывать, пока не проверим
                //   возможность пополнения ... а проверка эта реализуется в самом
                //   методе пополнения дочернего класса

                // 1й: пополнение счета, переданного в параметре
                account.addMoney(amount);
                // 2й: списание с текущего счета
                this.balance -= amount;

                System.out.printf("Перевод %d с %s на %s совершен успешно%n%n", amount,
                                  this.code, account.code);
            } catch (Exception e) {
                System.out.println("Операция завершилась ошибкой");
            }
        }
    }

    // пополнение счета
    void addMoney(int amount) {
        System.out.println("\n\n------------------------------------------------------");
        System.out.println(" ПОПОЛНЕНИЕ");
        System.out.println(this.code);
    }
}
