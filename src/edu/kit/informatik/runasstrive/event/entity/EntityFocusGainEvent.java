package edu.kit.informatik.runasstrive.event.entity;

import edu.kit.informatik.runasstrive.entity.Entity;

/**
 * Event which will be called when an entity gained focus.
 *
 * @author uvgsj
 * @version v0.1
 */
public class EntityFocusGainEvent extends EntityEvent {

    private final int focusGain;

    /**
     * Creates a new entity focus gain event.
     *
     * @param entity The entity that gained focus
     * @param focusGain The amount of focus
     */
    public EntityFocusGainEvent(Entity entity, int focusGain) {
        super(entity);

        this.focusGain = focusGain;
    }

    /**
     * Returns the amount of focus
     *
     * @return The amount of focus
     */
    public int getAmount() {
        return this.focusGain;
    }
}