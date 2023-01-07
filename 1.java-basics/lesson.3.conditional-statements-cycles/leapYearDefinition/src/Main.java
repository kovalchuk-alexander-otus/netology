import ru.maki.Game;
import ru.maki.Times;

public class Main {
    public static void main(String[] args) {


        Game.guessLeapYear();


    }

    // первая домашка
    public static void getDayInYear(){
        while (true) {
            int year = Times.getYear();
            if (year >= 0) {
                System.out.printf("Колличество дней %d%n%n", Times.getDayInYear(year));
            }
        }
    }
}