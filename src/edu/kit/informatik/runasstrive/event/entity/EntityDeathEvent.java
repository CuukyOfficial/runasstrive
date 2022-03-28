package edu.kit.informatik.runasstrive.event.entity;

import edu.kit.informatik.runasstrive.entity.Entity;

/**
 * Event which will be called if an entity dies.
 *
 * @author uvgsj
 * @version v0.1
 */
public class EntityDeathEvent extends EntityEvent {

    /**
     * Creates a new entity death event.
     *
     * @param entity The entity that died
     */
    public EntityDeathEvent(Entity entity) {
        super(entity);
    }
}