import ru.maki.Bill;
import ru.maki.TaxService;
import ru.maki.taxtype.IncomeTaxType;
import ru.maki.taxtype.ProgressiveTaxType;
import ru.maki.taxtype.TaxType;
import ru.maki.taxtype.VATaxType;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {

    public static void main(String[] args) {
        pay();
    }

    public static void pay(){
        TaxService taxService = new TaxService();
        Bill[] payments = new Bill[] {
                new Bill(new BigDecimal(100000.01),new IncomeTaxType(),new TaxService()),
                new Bill(new BigDecimal(100000.01),new VATaxType(),new TaxService()),
                new Bill(new BigDecimal(100000.01),new ProgressiveTaxType(),new TaxService()),
                new Bill(new BigDecimal(99999.99),new IncomeTaxType(),new TaxService()),
                new Bill(new BigDecimal(99999.99),new VATaxType(),new TaxService()),
                new Bill(new BigDecimal(99999.99),new ProgressiveTaxType(),new TaxService()),
                new Bill(new BigDecimal(99999.99),new TaxType(),new TaxService())
        };
        for (int i = 0; i < payments.length; ++i) {
            Bill bill = payments[i];
            bill.payTaxes();
        }
    }




    // знакомство с BigDecimal
    private static void testBigDecimal(){
        System.out.println(getSum(new BigDecimal(23.23), new BigDecimal(24.35)).setScale(2, RoundingMode.HALF_UP));
        System.out.println(getSum(new BigDecimal(0.2), new BigDecimal(0.1)).setScale(2, RoundingMode.HALF_UP));

        System.out.println(new BigDecimal(0.2).compareTo(new BigDecimal(0.1)));
        System.out.println(new BigDecimal(0.1).compareTo(new BigDecimal(0.2)));
        System.out.println(new BigDecimal(0.1).compareTo(new BigDecimal(0.1)));
        System.out.println(new BigDecimal(23.2).compareTo(new BigDecimal(4.1)));
        System.out.println(new BigDecimal(344.1).compareTo(new BigDecimal(42340.2)));
        System.out.println(new BigDecimal(4340.1).compareTo(new BigDecimal(423.1)));
    }

    // первое касание BigDecimal - складывание двух чисел
    public static BigDecimal getSum(BigDecimal a, BigDecimal b){
        return a.add(b);
    }
}