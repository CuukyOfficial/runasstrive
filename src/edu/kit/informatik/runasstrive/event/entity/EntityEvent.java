package edu.kit.informatik.runasstrive.event.entity;

import edu.kit.informatik.runasstrive.entity.Entity;
import edu.kit.informatik.runasstrive.event.Event;

/**
 * Represents any event which was associated with an entity.
 *
 * @author uvgsj
 * @version v0.1
 */
public class EntityEvent implements Event {

    private final Entity entity;

    /**
     * Creates a new entity event.
     *
     * @param entity The entity associated with this event
     */
    protected EntityEvent(Entity entity) {
        this.entity = entity;
    }

    /**
     * Returns the entity of the event.
     *
     * @return The entity of the event
     */
    public Entity getEntity() {
        return this.entity;
    }
}