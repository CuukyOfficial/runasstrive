package edu.kit.informatik.runasstrive.event;

/**
 * Represents a subscriber of any event.
 *
 * @param <T> The event
 * @author uvgsj
 * @version v0.1
 */
@FunctionalInterface
public interface Subscriber<T extends Event> {

    /**
     * Method that will be executed if the event was triggered
     *
     * @param event The event
     */
    void onEvent(T event);

}