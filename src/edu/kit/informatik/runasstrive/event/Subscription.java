package edu.kit.informatik.runasstrive.event;

/**
 * Represents a subscription to an event.
 *
 * @param <T> The type of the event
 * @author uvgsj
 * @version 1.0
 */
public record Subscription<T extends Event>(Class<T> clazz, Subscriber<T> subscriber) {

    /**
     * Notifies the subscriber about the event.
     * Cautions: This method is not type-safe and may throw a {@link ClassCastException} if the event is not of the correct type.
     *
     * @param event The event to notify the subscriber about
     */
    public void notify(Event event) {
        subscriber.onEvent(this.clazz.cast(event));
    }
}
