package edu.kit.informatik.runasstrive.event.entity;

import edu.kit.informatik.runasstrive.entity.Entity;
import edu.kit.informatik.runasstrive.event.Event;

public class EntityEvent extends Event {

    private final Entity entity;

    protected EntityEvent(Entity entity) {
        this.entity = entity;
    }

    public Entity getEntity() {
        return this.entity;
    }
}