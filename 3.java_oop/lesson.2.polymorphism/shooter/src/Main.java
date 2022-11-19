import ru.maki.Player;
import ru.maki.weapon.Weapon;
import ru.maki.weapon.firearms.Bazooka;
import ru.maki.weapon.steelarms.BodyArmor;
import ru.maki.weapon.steelarms.Knife;
import ru.maki.weapon.firearms.Revolver;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // test();
        game();
    }

    public static void game() {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player("Tom Sawyer");
        player.setWeapons(new Weapon[]{
                new Revolver(100, 6),
                new BodyArmor(30),
                new Bazooka(450, 1),
                new Knife(10)});

        String input;
        int idx;
        while (true) {
            player.showAvailable();
            System.out.print("Из чего стрелять изволите, сударь - введите номер или \"end\"\n> ");
            input = scanner.nextLine();

            if (input.equals("end")) break;

            try {
                idx = Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Вы ввели видимо не то, что требовалось - попробуйте еще раз");
                continue;
            }
            if (player.getWeapons().length < idx) {
                System.out.println("в наличии нет такого пистоля - скорректируйте номер");
                continue;
            }
            player.activeWeapon(idx);
            if (idx == 1 || idx == 3) player.getUseFireArms().makeShot();
            else System.out.println("сие не стреляет");
        }
    }

    public static void test() throws InterruptedException {
        Player player = new Player("Tom Sawyer");
        // шасть по карманам - что есть из стволов/брони
        player.showAvailable();

        // надыбали пушку
        Revolver revolver = new Revolver(100, 6);
        player.putWeapon(revolver);
        player.showAvailable();

        // подобрали нож
        Knife knife = new Knife(10);
        player.putWeapon(knife);
        player.showAvailable();

        // о, броник и базука в одном флаконе
        BodyArmor bodyArmor = new BodyArmor(30);
        Bazooka bazooka = new Bazooka(450, 1);
        player.putWeapon(bodyArmor);
        player.putWeapon(bazooka);
        player.showAvailable();

        // ...чу ...шорох ...а возьму-ка я орудие на изготовку
        player.activeWeapon(2);
        player.getUseSteelArms().showDetail();

        player.activeWeapon(1);

        // ...засада!!! пли!!!
        player.getUseFireArms().makeShot();
        player.getUseFireArms().recharge();


        player.getUseFireArms().makeShot();
        player.getUseFireArms().makeShot();
        player.getUseFireArms().makeShot();
        player.getUseFireArms().makeShot();
        player.getUseFireArms().makeShot();

        player.getUseFireArms().recharge(1);

        Thread.sleep(2000);
        player.getUseFireArms().recharge(2);
    }
}