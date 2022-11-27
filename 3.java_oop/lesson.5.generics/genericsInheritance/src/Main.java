import ru.maki.*;
import ru.maki.containers.FruitsBox;
import ru.maki.containers.VegetableBox;

public class Main {
    public static void main(String[] args) {

        FruitsBox<String, Fruits> fruitsBox = new FruitsBox<>();

        Fruits[] fruits = new Fruits[]{new Banana(), new Apple()};

        for (Fruits fruit : fruits) {
            fruitsBox.putIntoBox(fruit.getName(), fruit);
        }

        VegetableBox<String, Vegetables> vegetableBox = new VegetableBox<>();

        Vegetables[] vegetables = new Vegetables[]{new Cabbage(), new Potatoes()};

        for (Vegetables vegetable : vegetables) {
            vegetableBox.putIntoBox(vegetable.getName(), vegetable);
        }

    }
}