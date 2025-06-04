package org.example;

public interface Subscriber<T> {
    void notify(T event);

}
