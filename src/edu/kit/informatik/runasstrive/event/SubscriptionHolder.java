package edu.kit.informatik.runasstrive.event;

/**
 * Represents an object which can contain events and
 * their subscriptions. It can notify events if triggered.
 *
 * @author uvgsj
 * @version v0.1
 */
public interface SubscriptionHolder {

    /**
     * Notify the events of the given event's class.
     *
     * @param event The class of the event
     * @param <T> The event
     */
    <T extends Event> void notify(T event);

    /**
     * Registers subscription to an event.
     *
     * @param eventClass The class of the event
     * @param subscriber The subscriber of the event
     * @param <T> The event
     */
    <T extends Event> void subscribe(Class<T> eventClass, Subscriber<T> subscriber);

}