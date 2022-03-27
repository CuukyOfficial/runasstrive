package edu.kit.informatik.runasstrive.event.entity;

import edu.kit.informatik.runasstrive.ability.EntityApplicable;
import edu.kit.informatik.runasstrive.entity.Entity;

public class EntityAbilityUseEvent extends EntityEvent {

    private final EntityApplicable ability;

    public EntityAbilityUseEvent(Entity entity, EntityApplicable ability) {
        super(entity);
        this.ability = ability;
    }

    public EntityApplicable getAbility() {
        return this.ability;
    }
}
