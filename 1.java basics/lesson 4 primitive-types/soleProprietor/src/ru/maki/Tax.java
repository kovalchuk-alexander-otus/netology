package ru.maki;

public class Tax {

    private final String TAX_INCOME = "УСН доходы";
    private final String TAX_NET_INCOME = "УСН доходы минус расходы";

    private double income; // доход
    private double consumption; // расход

    public Tax(double income, double consumption) {
        this.income = income;
        this.consumption = consumption;
    }

    // суммируем доходы
    public void addIncome(String income) {
        try {
            this.income += Double.parseDouble(income);
        } catch (NumberFormatException e) {
            System.out.printf("Вы ввели некорректное значение [%s], допускается число с двумя знаками после запятой\n\n",
                    income);
        }
    }

    // суммируем расходы
    public void addConsumption(String consumption) {
        try {
            this.consumption += Double.parseDouble(consumption);
        } catch (NumberFormatException e) {
            System.out.printf("Вы ввели некорректное значение [%s], допускается число с двумя знаками после запятой\n\n",
                    consumption);
        }
    }

    // УСН доходы - налог 6% от доходов
    public double incomeTax() {
        return this.income * 0.06;
    }

    // УСН доходы минус расходы - налог 15% от разницы доходов и расходов
    public double netIncomeTax() {
        return (this.income - this.consumption) > 0 ? (this.income - this.consumption) * 0.15 : 0;
    }

    // Рекомендации лучших собаководов по налогообложению
    public void bestChoice() {
        String sample = "Мы советуем вам %s\n" +
                "Ваш налог составит: %.2f рублей\n" +
                "Налог на другой системе: %.2f рублей\n" +
                "Экономия: %.2f рублей";
        double incomeTax = incomeTax();
        double netIncomeTax = netIncomeTax();

        if (incomeTax < netIncomeTax) {
            System.out.printf(sample, TAX_INCOME, incomeTax, netIncomeTax, (netIncomeTax - incomeTax));
        } else {
            System.out.printf(sample, TAX_NET_INCOME, netIncomeTax, incomeTax, (incomeTax - netIncomeTax));
        }
        System.out.println();
        System.out.println();
    }
}
