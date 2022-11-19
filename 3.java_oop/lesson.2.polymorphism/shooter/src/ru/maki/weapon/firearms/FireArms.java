package ru.maki.weapon.firearms;

import ru.maki.weapon.Weapon;

public class FireArms extends Weapon {
    int magazineCapacity; // емкость магазина
    int numberOfShots; // число выстрелов (сколько сейчас конкретно заряжено)
    public FireArms(String name, String description, int price, int magazineCapacity) {
        super(name, description, price);
        this.magazineCapacity = magazineCapacity;
    }

    // сделай выстрел
    public void makeShot() {
        if (this.numberOfShots > 0) {
            System.out.println(" ...эхо выстрела");
            this.numberOfShots--;
        } else {
            System.out.println("чик  ...упс, надо зарядить\n");
        }
    }

    // выполни перезарядку полностью
    public void recharge() throws InterruptedException {
        recharge(this.magazineCapacity);
    }

    // выполни перезарядку на известное число
    public void recharge(int ammo) throws InterruptedException {
        int need = Math.min(ammo, this.magazineCapacity - this.numberOfShots);
        if (need <= 0) {
            System.out.printf("Заряжено %d\n\n", this.numberOfShots);
            return;
        }
        this.numberOfShots++;
        Thread.sleep(500);
        System.out.println("чпоньк");
        recharge(--need);
    }
}
