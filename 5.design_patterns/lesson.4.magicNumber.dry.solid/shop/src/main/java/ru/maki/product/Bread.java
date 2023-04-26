package ru.maki.product;

import ru.maki.client.Country;

public class Bread extends Product {
    final boolean isBlack; // черный (белый)
    final boolean isRye; // ржаной (пшеничный)
    final boolean isUnleavened; // бездрожжевой (дрожжевой)

    public Bread(String name, int price, int rating, Country country, boolean color, boolean isRye, boolean isUnleavened) {
        super("bread", name, price, rating, country);
        this.isBlack = color;
        this.isRye = isRye;
        this.isUnleavened = isUnleavened;
    }

    // отобразить Покупателю список уникальных параметров, которые необходимо указать для выбора Продукта
    @Override
    public void showUniqueProductParameter(){
        System.out.println("Укажите название (name) хлебо-булочного изделия: ");
    }

    // проверка соответствия продукта, указанным Покупателем параметрам
    @Override
    public boolean checkProductParams(String[] params) {
        if (params.length != 1) {
            return false;
        }
        if (this.name.equals(params[0])) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Bread bread = (Bread) o;

        if (isBlack != bread.isBlack) return false;
        if (isRye != bread.isRye) return false;
        return isUnleavened == bread.isUnleavened;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (isBlack ? 1 : 0);
        result = 31 * result + (isRye ? 1 : 0);
        result = 31 * result + (isUnleavened ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Bread : {" +
                "isBlack=" + (isBlack ? "черный" : "белый") +
                ", isRye=" + (isRye ? "ржаной" : "пшеничный") +
                ", isUnleavened=" + (isUnleavened ? "бездрожжевой" : "дрожжевой") +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", country=" + country +
                '}';
    }
}
