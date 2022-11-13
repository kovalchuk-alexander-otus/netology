import ru.maki.Fild;

public class Main {
    public static void main(String[] args) {
        // game();
        Fild fild = new Fild(10);
        fild.makeFild(27);
        check(fild.getFild(),3,7);
    }

    // игра на рандоме
    public static void game() {
        Fild fild = new Fild(9);
        fild.game(19);
    }

    // проверка ДЗ
    public static void check(char[][] fild, int row, int column){
        Fild f = new Fild(fild);
        f.setMen(row, column);
        f.game();
    }

}