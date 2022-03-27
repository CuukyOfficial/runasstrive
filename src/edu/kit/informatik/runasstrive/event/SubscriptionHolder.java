package edu.kit.informatik.runasstrive.event;

public interface SubscriptionHolder {

    <T extends Event> void notify(T event);

    <T extends Event> void subscribe(Class<T> eventClass, Subscribable<T> subscriber);

}