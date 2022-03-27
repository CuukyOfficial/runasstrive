package edu.kit.informatik.runasstrive.event.entity;

import edu.kit.informatik.runasstrive.entity.Entity;

public class EntityFocusGainEvent extends EntityEvent {

    private final int focusGain;

    public EntityFocusGainEvent(Entity entity, int focusGain) {
        super(entity);

        this.focusGain = focusGain;
    }

    public int getAmount() {
        return this.focusGain;
    }
}