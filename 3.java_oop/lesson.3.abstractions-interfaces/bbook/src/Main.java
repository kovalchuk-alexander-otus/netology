import ru.maki.Account;
import ru.maki.CreditAccount;
import ru.maki.SimpleAccount;

public class Main {
    public static void main(String[] args) {

        // создадим простой и кредитный Счета
        System.out.println();
        Account simpleAccount = new SimpleAccount(0);
        System.out.println(simpleAccount.getBalance());
        Account credAccount = new CreditAccount(-1000, 100_000);
        System.out.println(credAccount.getBalance());

        // пополним простой Счёт
        System.out.println();
        System.out.println(simpleAccount.add(100_000));
        System.out.println(simpleAccount.getBalance());

        // попытаемся положить деньги на кредитный Счёт
        System.out.println();
        System.out.println(credAccount.add(10000));
        System.out.println(credAccount.getBalance());
        System.out.println(credAccount.add(1000));
        System.out.println(credAccount.getBalance());

        // попытаемся перевести деньги с кредитного на простой. а потом наоборот
        System.out.println();
        System.out.println(credAccount.transfer(simpleAccount,101_000)); // нарушим Лимит
        System.out.println(simpleAccount.getBalance());
        System.out.println(credAccount.getBalance());
        System.out.println(credAccount.transfer(simpleAccount,100_000)); // в рамках Лимита
        System.out.println(simpleAccount.getBalance());
        System.out.println(credAccount.getBalance());
        System.out.println(simpleAccount.transfer(credAccount,101_000)); // превысим Лимит при погашении кредита
        System.out.println(simpleAccount.getBalance());
        System.out.println(credAccount.getBalance());
        System.out.println(simpleAccount.transfer(credAccount,100_000)); // совершим погашение кредита в рамках
        // Задолженности
        System.out.println(simpleAccount.getBalance());
        System.out.println(credAccount.getBalance());
    }
}