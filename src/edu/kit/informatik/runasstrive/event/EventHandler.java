package edu.kit.informatik.runasstrive.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Can hold events and notifies subscriber if an event was triggered.
 *
 * @author uvgsj
 * @version v0.1
 */
public class EventHandler implements SubscriptionHolder {

    private final Map<Class<?>, List<Subscriber<?>>> subscriptions;

    /**
     * Creates new event handler without any subscriptions.
     */
    public EventHandler() {
        this.subscriptions = new HashMap<>();
    }

    @Override
    public <T extends Event> void notify(T event) {
        List<Subscriber<?>> subs = this.subscriptions.get(event.getClass());
        if (subs != null) for (Subscriber<?> sub : subs) ((Subscriber<T>) sub).onEvent(event);
    }

    @Override
    public <T extends Event> void subscribe(Class<T> eventClass, Subscriber<T> subscriber) {
        this.subscriptions.putIfAbsent(eventClass, new ArrayList<>());
        this.subscriptions.get(eventClass).add(subscriber);
    }
}