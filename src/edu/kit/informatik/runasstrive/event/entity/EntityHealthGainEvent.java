package edu.kit.informatik.runasstrive.event.entity;

import edu.kit.informatik.runasstrive.entity.Entity;

public class EntityHealthGainEvent extends EntityEvent {

    private final int amount;

    public EntityHealthGainEvent(Entity entity, int amount) {
        super(entity);

        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }
}
