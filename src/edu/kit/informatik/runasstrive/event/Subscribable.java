package edu.kit.informatik.runasstrive.event;

@FunctionalInterface
public interface Subscribable<T extends Event> {

    void onEvent(T event);

}