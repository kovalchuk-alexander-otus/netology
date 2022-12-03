package ru.maki;

import java.util.Arrays;

// событие
public abstract class Event {
    EventType eventType;
    final String title; // название
    final int    releaseYear; // год выпуска
    final int    age; // ограничение по возрасту

    public Event(String title, int releaseYear, int age) {
        this.title       = title;
        this.releaseYear = releaseYear;
        this.age         = age;
    }

    public void checkEvent() {
        if (this.title == null || this.title.isEmpty())
            throw new RuntimeException("Не заполненено название мероприятия.\n" + this);
        if (this.releaseYear == 0)
            throw new RuntimeException("Не заполнен год выпуска.\n" + this);
        if (this.age == 0)
            throw new RuntimeException("Не заполнено ограничение по возврасту.\n" + this);
    }

    public EventType getEventType() {
        return eventType;
    }

    public static Event[] getEventsByType(Event[] events, EventType eventType) {
        Event[] newEvents = new Event[0];
        for (Event event : events) {
            if (event.getEventType() == eventType) {
                newEvents                       = Arrays.copyOf(newEvents, newEvents.length + 1);
                newEvents[newEvents.length - 1] = event;
            }
        }

        return newEvents;
    }

    // проверка коллекции
    public static void checkCollection(Event[] events) {
        for (Event event : events) {
            event.checkEvent();
            // System.out.println(event);
        }
        System.out.println("Все события корректны.");
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventType=" + eventType +
                ", title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", age=" + age +
                '}';
    }
}
