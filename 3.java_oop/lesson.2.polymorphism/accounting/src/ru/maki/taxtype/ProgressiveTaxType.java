package ru.maki.taxtype;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProgressiveTaxType extends TaxType {

    @Override
    // Прогрессивный налог, до 100 тысяч = 10%, больше 100 тысяч = 15%
    public BigDecimal calculateTaxFor(BigDecimal amount) {
        return amount.multiply(
                new BigDecimal(amount.compareTo(new BigDecimal(100000)) >= 0 ? 0.15 : 0.10)
        ).setScale(2, RoundingMode.HALF_UP);
    }
}
