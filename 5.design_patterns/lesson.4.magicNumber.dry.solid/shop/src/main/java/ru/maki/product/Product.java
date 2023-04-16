package ru.maki.product;

public abstract class Product implements Comparable<Product> {
    protected String type; // тип продукта
    protected String name; // название продукта
    protected int price; // стоимость продукта
    protected int rating; // рейтинг продукта
    protected Country country; // страна происхождения

    public enum Country {RUSSIA, CHINA, BRASILIA, INDIA, IRAN, AZERBAIJAN, BELARUS}

    ;

    public Product(String type, String name, int price, int rating, Country country) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!type.equals(product.type)) return false;
        if (!name.equals(product.name)) return false;
        return country == product.country;
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + country.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", country=" + country +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        int i = this.type.compareTo(o.type);
        return i != 0 ?
                i : this.hashCode() == o.hashCode() ?
                    0 : this.hashCode() > o.hashCode() ?
                        1 : -1;
    }
}