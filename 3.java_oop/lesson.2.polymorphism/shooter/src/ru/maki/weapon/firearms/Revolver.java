package ru.maki.weapon.firearms;

public class Revolver extends FireArms {

    public Revolver(int price, int magazineCapacity) {
        super("Револьвер", "Многозарядное короткоствольное стрелковое оружие с вращающимся барабаном,\n" +
                " выполняющим функцию магазина. Барабан имеет несколько камор, в которых располагаются боеприпасы.\n" +
                " В момент выстрела очередная камора служит патронником.\n", price, magazineCapacity);
    }


    @Override
    public void makeShot() {
        super.makeShot();
        System.out.println("пиф-паф");
    }
}
