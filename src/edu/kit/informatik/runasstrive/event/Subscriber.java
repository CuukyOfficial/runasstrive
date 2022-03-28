package edu.kit.informatik.runasstrive.event;

/**
 * Represents a subscriber of any event.
 *
 * @author uvgsj
 * @version v0.1
 */
@FunctionalInterface
public interface Subscriber<T extends Event> {

    void onEvent(T event);

}