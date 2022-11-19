package ru.maki;

import ru.maki.weapon.firearms.FireArms;
import ru.maki.weapon.steelarms.SteelArms;
import ru.maki.weapon.Weapon;

import java.util.Arrays;

public class Player {
    String nickName;
    Weapon[] weapons;
    Weapon useWeapon;

    public Player(String nickName) {
        this.nickName = nickName;
    }

    public void setWeapons(Weapon[] weapons) {
        this.weapons = weapons;
    }

    public Weapon[] getWeapons() {
        return weapons;
    }

    // метод пушит в набор очередной ствол
    public void putWeapon(Weapon weapon) {
        int len = 0;
        if (this.weapons != null) len = this.weapons.length;
        Weapon[] newWeapons = new Weapon[len + 1];

        if (this.weapons == null) {
            newWeapons[0] = weapon;
        } else {
            newWeapons = Arrays.copyOf(this.weapons, this.weapons.length + 1);
            newWeapons[len] = weapon;
        }
        this.weapons = newWeapons;
    }

    // показывает доступные стволы
    public void showAvailable() {
        System.out.println("\n что имеем..");
        if (this.weapons == null) System.out.println("Увы, пока расчитываем на силу рук и скорость ног :)");
        else {
            for (int i = 0; i < this.weapons.length; i++) {
                System.out.printf(" %d) %s\n", (i + 1), this.weapons[i].getName());
            }
        }
        System.out.println("\n\n");
    }

    // метод активурует один из стволов в наборе
    public void activeWeapon(int idx) {
        this.useWeapon = this.weapons[idx - 1];
        System.out.printf(" ...как-то поспокойнее держать в руках %s\n\n", this.useWeapon.getName());
    }

    //

    public FireArms getUseFireArms() {
        return (FireArms) useWeapon;
    }

    public SteelArms getUseSteelArms() {
        return (SteelArms) useWeapon;
    }
}
