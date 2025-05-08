package org.example;

public interface Subscriber<T> {
    public void notify(T event);
}
