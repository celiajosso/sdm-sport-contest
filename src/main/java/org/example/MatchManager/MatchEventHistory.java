package org.example.MatchManager;

import java.util.ArrayList;
import org.example.Subscriber;
import org.example.Events.Event;

public class MatchEventHistory {
    private ArrayList<Event> eventHistory;
    private ArrayList<Subscriber<Event>> subscribers;

    public void setEventHistory() {
        this.eventHistory = new ArrayList<>();
        this.subscribers = new ArrayList<>();
    }

    public void setSubscribers(ArrayList<Subscriber<Event>> subscribers) {
        this.subscribers = subscribers;
    }

    public ArrayList<Event> getEventHistory() {
        return eventHistory;
    }

    public ArrayList<Subscriber<Event>> getSubscribers() {
        return subscribers;
    }

    public MatchEventHistory() {
        this.eventHistory = new ArrayList<>();
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
        if (subscribers == null) {
            subscribers = new ArrayList<>();
        }
        subscribers.add(subscriber);
    }
    public void removeSubscriber(Subscriber<Event> subscriber) {
        if (subscribers != null) {
            subscribers.remove(subscriber);
        }
    }

    public void notifySubscribers(Event event) {
        for (Subscriber<Event> subscriber : subscribers) {
            subscriber.notify(event);
        }
    }
}
