package ru.maki.taxtype;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class IncomeTaxType extends TaxType{

    @Override
    // Подоходный налог = 13%
    public BigDecimal calculateTaxFor(BigDecimal amount) {
        return amount.multiply(new BigDecimal(0.13)).setScale(2, RoundingMode.HALF_UP);
    }
}
