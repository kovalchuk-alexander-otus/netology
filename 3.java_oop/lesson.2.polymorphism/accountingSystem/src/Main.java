import ru.maki.Company;
import ru.maki.deals.*;
import ru.maki.taxes.*;

public class Main {
    public static void main(String[] args) {

        Company company = new Company("Pioneer", new TaxSystem());
//        System.out.println(company.getDebit());
//        System.out.println(company.getCredit());
//        System.out.println(company.getDebit());
//        System.out.println(company.getCredit());
//        TaxSystem incomeTax = new IncomeTax();
//        System.out.printf("incomeTax : %s%n", incomeTax.calcTaxFor(company.getDebit(), company.getCredit()).toString());
//        TaxSystem netIncomeTax = new NetIncomeTax();
//        System.out.printf("netIncomeTax : %s%n", netIncomeTax.calcTaxFor(company.getDebit(), company.getCredit()).toString());


        System.out.println("____________________\n  ДЗ #1 \n~~~~~~~~~~~~~~~~~~~~");
        company.shiftMoney(12433);
        company.shiftMoney(-1343);
        company.setTaxSystem(new IncomeTax());
        company.payTaxes();
        company.shiftMoney(12433);
        company.shiftMoney(-1343);
        company.setTaxSystem(new NetIncomeTax());
        company.payTaxes();


        System.out.println("\n____________________\n  ДЗ #2 \n~~~~~~~~~~~~~~~~~~~~");
        Deal[] deals = new Deal[]{
                new Sale("мёд", 1002),
                new Sale("мёд", 1002),
                new Sale("воск", 2001),
                new Sale("прополис", 10000),
                new Expenditure("пчелосемья", 4500),
                new Sale("воск", 2001),
                new Sale("мёд", 1002),
                new Sale("мёд", 1002),
                new Expenditure("улей", 7003)
        };
        int netIncome = company.applyDeals(deals);
        System.out.printf("Чистая прибыль : %d%n", netIncome);
        company.setTaxSystem(new IncomeTax());
        company.payTaxes();

        deals = new Deal[]{
                new Sale("мёд", 1002),
                new Sale("мёд", 1002),
                new Sale("воск", 2001),
                new Sale("прополис", 10000),
                new Expenditure("пчелосемья", 4500),
                new Sale("воск", 2001),
                new Sale("мёд", 1002),
                new Sale("мёд", 1002),
                new Expenditure("улей", 7003)
        };
        netIncome = company.applyDeals(deals);
        System.out.printf("Чистая прибыль : %d%n", netIncome);
        company.setTaxSystem(new NetIncomeTax());
        company.payTaxes();

    }
}