package ru.maki.taxtype;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class VATaxType extends TaxType{

    @Override
    // НДС = 18%
    public BigDecimal calculateTaxFor(BigDecimal amount) {
        return amount.multiply(new BigDecimal(0.18)).setScale(2, RoundingMode.HALF_UP);
    }
}
