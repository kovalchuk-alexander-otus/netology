package ru.maki;

public class Movie extends Event {
    public Movie(String title, int releaseYear, int age) {
        super(title, releaseYear, age);
        this.eventType = EventType.MOVIE;
    }

    // из общего массива события получаем только КИНО
    public static Event[] getMovies(Event[] events) {

        return Event.getEventsByType(events, EventType.MOVIE);
    }
}
