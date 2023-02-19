package ru.maki;

import ru.maki.deals.Deal;
import ru.maki.taxes.TaxSystem;

public class Company {
    final String title; // название
    int debit; // доходы
    int credit; // расходы
    TaxSystem taxSystem; // система налогообложения

    public Company(String title, TaxSystem taxSystem) {
        this.title = title;
        this.taxSystem = taxSystem;
    }

    // учет движений средств
    public void shiftMoney(int amount) {
        if (amount > 0) {
            this.debit += amount;
        } else {
            this.credit -= amount;
        }
    }

    // размер прибыли по факту учета всех совершенных сделок
    public int applyDeals(Deal[] deals) {
        System.out.println("  Выполним расчет чистой Прибыли..");
        for (Deal deal : deals) {
            System.out.println(deal.getComment());
            this.shiftMoney(deal.getDebitChange() - deal.getCreditChange());
        }
        int profit = this.debit - this.credit;
        this.payTaxes();
        return profit;
    }

    // уплата налога
    public void payTaxes() {
        System.out.printf("Компания %s уплатила налог в размере: %s руб.%n", this.title,
                this.taxSystem.calcTaxFor(this.debit, this.credit).toString());
        this.debit = 0;
        this.credit = 0;
    }

    public void setTaxSystem(TaxSystem taxSystem) {
        this.taxSystem = taxSystem;
    }

    public int getDebit() {
        return this.debit;
    }

    public int getCredit() {
        return this.credit;
    }
}