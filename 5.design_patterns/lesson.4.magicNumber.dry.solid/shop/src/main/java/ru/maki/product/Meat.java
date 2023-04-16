package ru.maki.product;

public class Meat extends Product{
    MeatType meatType; // тип мяса
    boolean isGroundMeat; // фарш
    public enum MeatType {PORK, BEEF, LAMB, POULTRY}
    public Meat(String name, int price, int rating, Country country, MeatType meatType, boolean isGroundMeat) {
        super("meat", name, price, rating, country);
        this.meatType = meatType;
        this.isGroundMeat = isGroundMeat;
    }

    // халяль (исключил свинину)
    public boolean isHalal(){
        return this.meatType != MeatType.PORK;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Meat meat = (Meat) o;

        if (isGroundMeat != meat.isGroundMeat) return false;
        return meatType == meat.meatType;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + meatType.hashCode();
        result = 31 * result + (isGroundMeat ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Meat : {" +
                "meatType=" + meatType +
                ", itGroundMeat=" + isGroundMeat +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", country=" + country +
                '}';
    }
}
