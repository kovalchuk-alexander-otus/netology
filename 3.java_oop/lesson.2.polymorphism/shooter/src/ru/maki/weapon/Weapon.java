package ru.maki.weapon;

public class Weapon {

    String name; // название
    String description; // описание
    int price; // стоимость

    public Weapon(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    // показывает детальную информацию по стволу
    public void showDetail() throws InterruptedException {
        System.out.println("  ...перекур - ознакомимся с теорией");
        System.out.println("Название: " + this.name);
        System.out.println("Описание: " + this.description);
        System.out.println("Цена: " + this.price);
        Thread.sleep(3000);
    }
}
