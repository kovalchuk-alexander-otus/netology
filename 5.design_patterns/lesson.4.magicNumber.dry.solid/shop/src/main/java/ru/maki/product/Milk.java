package ru.maki.product;

import ru.maki.client.Country;

public class Milk extends Product {
    protected final MilkType milkType; // тип молочки
    protected final double fatPercent; // процент жирности

    public enum MilkType {MILK, KEFIR, COTTAGE_CHEESE, SOUR_CREAM, BUTTER, CHEESE}

    public Milk(String name, int price, int rating, Country country, MilkType milkType, double fatPercent) {
        super("milk", name, price, rating, country);
        this.milkType = milkType;
        this.fatPercent = fatPercent;
    }

    // отобразить Покупателю список уникальных параметров, которые необходимо указать для выбора Продукта
    @Override
    public void showUniqueProductParameter() {
        System.out.println("Укажите название (name), тип (milkType), жирность(fatPercent) молочной продукции: ");
    }

    // проверка соответствия продукта, указанным Покупателем параметрам
    @Override
    public boolean checkProductParams(String[] params) {
        if (params.length != 3) {
            return false;
        }
        if (this.name.equals(params[0]) && this.milkType.toString().equals(params[1]) &&
                Double.compare(this.fatPercent, Double.parseDouble(params[2])) == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Milk milk = (Milk) o;

        if (Double.compare(milk.fatPercent, fatPercent) != 0) return false;
        return milkType == milk.milkType;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + milkType.hashCode();
        temp = Double.doubleToLongBits(fatPercent);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Milk : {" +
                "milkType=" + milkType +
                ", fatPercent=" + fatPercent +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", country=" + country +
                '}';
    }
}
