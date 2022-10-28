import ru.maki.TicTacToe;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // задаем размерность массива и признак выводить ход игры на экран или нет
        TicTacToe ticTacToe = new TicTacToe(5, false);

        // задаем число партий
        ticTacToe.gameComputer(8);

        System.out.println("Игра закончена!");
    }


}
