package edu.kit.informatik.runasstrive.event.entity;

import edu.kit.informatik.runasstrive.ability.ApplicableType;
import edu.kit.informatik.runasstrive.entity.Entity;

/**
 * Event which is called when an entity takes damage.
 *
 * @author uvgsj
 * @version v0.1
 */
public class EntityDamageEvent extends EntityEvent {

    private final ApplicableType damageType;
    private final int damage;

    /**
     * Creates a new entity damage event.
     *
     * @param entity The entity which got damaged
     * @param damageType The type of damage
     * @param damage The amount of damage
     */
    public EntityDamageEvent(Entity entity, ApplicableType damageType, int damage) {
        super(entity);
        this.damageType = damageType;
        this.damage = damage;
    }

    /**
     * Returns the type of damage.
     *
     * @return The type of damage
     */
    public ApplicableType getDamageType() {
        return this.damageType;
    }

    /**
     * Returns the amount of damage.
     *
     * @return The amount of damage
     */
    public int getDamage() {
        return this.damage;
    }
}