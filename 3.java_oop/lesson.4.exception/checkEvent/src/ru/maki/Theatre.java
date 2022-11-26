package ru.maki;

public class Theatre extends Event {
    public Theatre(String title, int releaseYear, int age) {
        super(title, releaseYear, age);
        this.eventType = EventType.THEATRE;
    }

    // из общего массива событий получаем только СПЕКТАКЛИ
    public static Event[] getTheatres(Event[] events) {

        return Event.getEventsByType(events, EventType.THEATRE);
    }
}
