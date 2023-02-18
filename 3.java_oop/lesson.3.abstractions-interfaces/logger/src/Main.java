import ru.maki.Logger;
import ru.maki.SimpleLogger;
import ru.maki.SmartLogger;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n~ SimpleLogger : example ~");
        Logger simpleLogger = new SimpleLogger();
        simpleLogger.log("отладка");
        simpleLogger.log("ERROR: отладка");
        simpleLogger.log("отладка error description");

        System.out.println("\n~ SmartLogger : example ~");
        Logger smartLogger = new SmartLogger();
        smartLogger.log("отладка");
        smartLogger.log("ERROR: отладка");
        smartLogger.log("отладка error description");
    }
}