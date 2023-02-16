package ru.maki.taxes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class IncomeTax extends TaxSystem {
    static final BigDecimal RATE_INCOME_TAX = BigDecimal.valueOf(0.06); // ставка налога на Доход

    @Override
    public BigDecimal calcTaxFor(int debit, int credit) {
        return RATE_INCOME_TAX.multiply(BigDecimal.valueOf(debit)).setScale(2, RoundingMode.CEILING);
    }
}