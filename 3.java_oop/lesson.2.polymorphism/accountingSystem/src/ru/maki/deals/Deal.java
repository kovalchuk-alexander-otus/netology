package ru.maki.deals;

public class Deal {
    final String comment; // описание сделки
    final int creditChange; // сумма расходов
    final int debitChange; // сумма доходов

    public Deal(String comment, int creditChange, int debitChange) {
        this.comment = comment;
        this.creditChange = creditChange;
        this.debitChange = debitChange;
    }

    public String getComment() {
        return comment;
    }

    public int getCreditChange() {
        return creditChange;
    }

    public int getDebitChange() {
        return debitChange;
    }
}