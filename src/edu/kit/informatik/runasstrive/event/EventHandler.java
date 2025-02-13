package edu.kit.informatik.runasstrive.event;

import java.util.*;

/**
 * Can hold events and notifies subscriber if an event was triggered.
 *
 * @author uvgsj
 * @version v0.1
 */
public class EventHandler implements SubscriptionHolder {

    private final Map<Class<?>, List<Subscription<?>>> subscriptions;

    /**
     * Creates new event handler without any subscriptions.
     */
    public EventHandler() {
        this.subscriptions = new HashMap<>();
    }

    @Override
    public void notify(Event event) {
        List<Subscription<?>> subs = this.subscriptions.get(event.getClass());
        if (subs == null) return;
        subs.forEach(sub -> sub.notify(event));
    }

    @Override
    public <T extends Event> void subscribe(Class<T> eventClass, Subscriber<T> subscriber) {
        this.subscriptions.putIfAbsent(eventClass, new LinkedList<>());
        this.subscriptions.get(eventClass).add(new Subscription<>(eventClass, subscriber));
    }
}