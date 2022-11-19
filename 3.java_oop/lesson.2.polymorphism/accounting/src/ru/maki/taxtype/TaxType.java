package ru.maki.taxtype;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxType {

    // на крайний случай - сделаем ставочку по умолчанию максимальновозможной - НДФЛ 35%
    public BigDecimal calculateTaxFor(BigDecimal amount) {
        return amount.multiply(new BigDecimal(0.35)).setScale(2, RoundingMode.HALF_UP);
    }
}
