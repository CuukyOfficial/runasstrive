package edu.kit.informatik.runasstrive.event.entity;

import edu.kit.informatik.runasstrive.entity.Entity;

public class EntityDeathEvent extends EntityEvent {

    public EntityDeathEvent(Entity entity) {
        super(entity);
    }
}