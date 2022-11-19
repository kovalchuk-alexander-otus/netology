package ru.maki.weapon.firearms;

public class Bazooka extends FireArms {
    public Bazooka(int price, int magazineCapacity) {
        super("Ручной противотанковый гранатомёт", "Разновидность индивидуального стрелкового оружия \n" +
                "(гранатомёт), предназначенная для уничтожения танков, броневых и иных целей реактивными гранатами.\n", price, magazineCapacity);
    }

    @Override
    public void makeShot() {
        super.makeShot();
        System.out.println("трах-тарарах-бдыщь-бдыщь");
    }
}
