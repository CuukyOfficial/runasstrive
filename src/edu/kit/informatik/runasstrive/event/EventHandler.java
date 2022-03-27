package edu.kit.informatik.runasstrive.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventHandler implements SubscriptionHolder {

    private final Map<Class<?>, List<Subscribable<?>>> subscriptions;

    public EventHandler() {
        this.subscriptions = new HashMap<>();
    }

    @Override
    public <T extends Event> void notify(T event) {
        List<Subscribable<?>> subs = this.subscriptions.get(event.getClass());
        if (subs != null) for (Subscribable<?> sub : subs) ((Subscribable<T>) sub).onEvent(event);
    }

    @Override
    public <T extends Event> void subscribe(Class<T> eventClass, Subscribable<T> subscriber) {
        this.subscriptions.putIfAbsent(eventClass, new ArrayList<>());
        this.subscriptions.get(eventClass).add(subscriber);
    }
}