package edu.kit.informatik.runasstrive.event.entity;

import edu.kit.informatik.runasstrive.entity.Entity;

/**
 * Event which will be called when an entity gains health
 *
 * @author uvgsj
 * @version v0.1
 */
public class EntityHealthGainEvent extends EntityEvent {

    private final int amount;

    /**
     * Creates a new entity health gain event.
     *
     * @param entity The entity that gains health
     * @param amount The amount of health
     */
    public EntityHealthGainEvent(Entity entity, int amount) {
        super(entity);

        this.amount = amount;
    }

    /**
     * Returns the amount of health.
     *
     * @return The amount of health
     */
    public int getAmount() {
        return this.amount;
    }
}
