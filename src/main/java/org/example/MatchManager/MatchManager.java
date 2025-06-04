package org.example.MatchManager;

import org.example.Events.Event;
import org.example.Match;
import org.example.Subscriber;
import org.example.contestant.Contestant;

import java.util.ArrayList;

public abstract class MatchManager {
    private final ArrayList<Event> eventHistory = new ArrayList<>();
    private final ArrayList<Subscriber<Event>> subscribers = new ArrayList<>();
    protected Match match;

    public MatchManager(Match match) {
        this.match = match;
    }

    public void reset() {
        eventHistory.clear();
        subscribers.clear();
    }

    public ArrayList<Event> getEventHistory() {
        return eventHistory;
    }

    public ArrayList<Subscriber<Event>> getSubscribers() {
        return subscribers;
    }

    public Event getEvent(Integer index) {
        if (index < 0 || index >= eventHistory.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return this.eventHistory.get(index);
    }

    public void addEvent(Event event) {
        eventHistory.add(event);
    }

    public void removeEvent(Event event) {
        eventHistory.remove(event);
    }

    public void addSubscriber(Subscriber<Event> subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber<Event> subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(Event event) {
        for (Subscriber<Event> subscriber : subscribers) {
            subscriber.notify(event);
        }
    }

    public void applyEvent(Event event) {
        if (event.execute()) {
            addEvent(event);
            notifySubscribers(event);
        }
    }

    public Match getMatch() {
        return this.match;
    }

    public abstract Contestant getWinner();
}
