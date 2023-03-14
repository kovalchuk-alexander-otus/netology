import ru.maki.Install;
import ru.maki.game.GameProgress;
import ru.maki.utils.Log;
import ru.maki.utils.Service;
import ru.maki.utils.Source;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // установка игры ..
        //  !!! корневая директория содержится в Service.getRootPath()
        //  !!! отлаживался на Ubuntu .. в своем хоме, на другом компе может потребоваться корректировка этого параметра
        Install install = new Install();
        install.run();

        // создаем три экземпляра игры ..
        GameProgress gameProgress1 = new GameProgress(10, 10, 1, 67.2);
        GameProgress gameProgress2 = new GameProgress(8, 7, 2, 163.7);
        GameProgress gameProgress3 = new GameProgress(4, 23, 7, 4237.0);

        // сохраняем походу пьесы ..
        Service.saveGame(Source.SAVE + "save1.dat", gameProgress1);
        Service.saveGame(Source.SAVE + "save2.dat", gameProgress2);
        Service.saveGame(Source.SAVE + "save3.dat", gameProgress3);

        // упаковываем все сохраненные на данный момент уровни ..
        List<String> saveFiles = Service.getSaveFiles();
        Service.zipFiles(Source.SAVE + "zip.zip", saveFiles);
        Service.delFiles(saveFiles);

        // распаковываем все уровни .. и поднимаем один из них
        Service.openZip(Source.SAVE + "zip.zip", Source.SAVE);
        GameProgress gameProgress = Service.openProgress(Source.SAVE + "save2.dat");
        System.out.println(gameProgress);

        // System.out.println(Log.log);
    }
}