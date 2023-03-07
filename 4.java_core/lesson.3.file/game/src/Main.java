import ru.maki.Install;
import ru.maki.game.GameProgress;

public class Main {
    public static void main(String[] args) {

        Install install = new Install();
        install.run();

        GameProgress gameProgress1 = new GameProgress(10, 10, 1, 67.2);
        GameProgress gameProgress2 = new GameProgress(8, 7, 2, 163.7);
        GameProgress gameProgress3 = new GameProgress(4, 23, 7, 4237.0);


//        Path path = Paths.get("/usr/games");
//        Files.list(path)
//                .forEach(System.out::println);
    }
}