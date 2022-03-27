package edu.kit.informatik.runasstrive.event.entity;

import edu.kit.informatik.runasstrive.ability.ApplicableType;
import edu.kit.informatik.runasstrive.entity.Entity;

public class EntityDamageEvent extends EntityEvent {

    private final ApplicableType damageType;
    private final int damage;

    public EntityDamageEvent(Entity entity, ApplicableType damageType, int damage) {
        super(entity);
        this.damageType = damageType;
        this.damage = damage;
    }

    public ApplicableType getDamageType() {
        return this.damageType;
    }

    public int getDamage() {
        return this.damage;
    }
}