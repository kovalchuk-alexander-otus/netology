package ru.maki;

public class Tax {

    final int RATE_INCOME = 6; // ставка Налога на доходы
    final int RATE_PROFIT = 15; // ставка Налога на прибыль
    final String NAME_TAX_OF_INCOME = "УСН доходы";
    final String NANE_TAX_OF_PROFIT = "УСН доходы минус расходы";
    final String NAME_TAX_ANY = "Можете выбрать любую систему налогообложения";
    private double income; // доход
    private double expense; // расход
    private double profit; // прибыль

    public Tax() {
        this.income = 0;
        this.expense = 0;
        this.profit = 0;
    }

    // добавляем информацию о Доходе
    public void setIncome(double income) {
        this.income += income;
        this.profit += income;
    }

    // добавляем информацию о Расходе
    public void setExpense(double expense) {
        this.expense += expense;
        this.profit -= expense;
    }

    // налог на доход
    public double getTaxOfIncome() {
        return this.income * RATE_INCOME / 100;
    }

    // налог на прибыль
    public double getTaxOfProfit() {
        return this.profit > 0 ? this.profit * RATE_PROFIT / 100 : 0;
    }

    //
    public void choiceBestTax() {
        double taxOfIncome = this.getTaxOfIncome();
        double taxOfProfit = this.getTaxOfProfit();
        String taxName;
        double taxRecommended, taxOther;

        if (taxOfIncome == taxOfProfit) {
            System.out.println(NAME_TAX_ANY);
        } else {
            if (taxOfIncome > taxOfProfit) {
                taxName = NANE_TAX_OF_PROFIT;
                taxRecommended = taxOfProfit;
                taxOther = taxOfIncome;
            } else {
                taxName = NAME_TAX_OF_INCOME;
                taxRecommended = taxOfIncome;
                taxOther = taxOfProfit;
            }
            System.out.printf("Мы советуем вам %s\n" +
                            "Ваш налог составит: %.2f рублей\n" +
                            "Налог на другой системе: %.2f рублей\n" +
                            "Экономия: %.2f рублей%n", taxName, taxRecommended, taxOther,
                    Math.round(taxOther * 100) / 100.0 - Math.round(taxRecommended * 100) / 100.0);
        }
    }
}
