package ru.maki.taxes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NetIncomeTax extends TaxSystem {
    static final BigDecimal RATE_NET_INCOME_TAX = BigDecimal.valueOf(0.15); // ставка налога на Прибыль

    @Override
    public BigDecimal calcTaxFor(int debit, int credit) {
        return debit > credit ?
                RATE_NET_INCOME_TAX.multiply(BigDecimal.valueOf(debit - credit)).setScale(2, RoundingMode.CEILING) :
                BigDecimal.valueOf(0).setScale(2, RoundingMode.CEILING);
    }
}