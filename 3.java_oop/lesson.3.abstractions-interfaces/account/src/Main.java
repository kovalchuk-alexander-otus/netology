import ru.maki.CheckingAccount;
import ru.maki.CreditAccount;
import ru.maki.SavingsAccount;

public class Main {
    public static void main(String[] args) {

        SavingsAccount savingsAccount = new SavingsAccount("42306810230230243923");
        CreditAccount creditAccount = new CreditAccount("40506810102320147384");
        CheckingAccount checkingAccount = new CheckingAccount("40817810203239045829");


        checkingAccount.transfer(savingsAccount, 100);

        checkingAccount.addMoney(100_000);
        System.out.println(checkingAccount.toString());

        checkingAccount.transfer(savingsAccount, 100);
        System.out.println(savingsAccount.toString());

        checkingAccount.transfer(checkingAccount, 100);
        System.out.println(checkingAccount.toString());

        checkingAccount.transfer(creditAccount, 100);
        System.out.println(creditAccount.toString());

        creditAccount.pay(1_000_000);
        creditAccount.transfer(savingsAccount,10_000);

        savingsAccount.addMoney(20_000);
        savingsAccount.pay(10_000);

        savingsAccount.transfer(creditAccount, 10_000);
    }
}