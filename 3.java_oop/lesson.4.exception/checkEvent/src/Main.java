import ru.maki.Event;
import ru.maki.Movie;
import ru.maki.Theatre;

public class Main {
    public static void main(String[] args) {
        Event[] events = new Event[]{
                new Movie("Гардемарины", 1984, 5)
                , new Movie("Калигула", 1984, 18)
                , new Movie("Красная жара", 1984, 14)
                , new Movie("Остров", 2009, 3)
                , new Theatre("Домиздат-3", 2000, 10)
                , new Theatre("Дети священника", 2004, 14)
                , new Theatre("Служанки", 2001, 18)
                , new Theatre("Король Лир", 2004, 8)
        };

        // проверка Кино
        Event[] movies = Movie.getMovies(events);
        Event.checkCollection(movies);

        // проверка Спектаклей
        Event[] theatres = Theatre.getTheatres(events);
        Event.checkCollection(theatres);

    }

}