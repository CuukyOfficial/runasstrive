package edu.kit.informatik.runasstrive.event.entity;

import edu.kit.informatik.runasstrive.ability.EntityApplicable;
import edu.kit.informatik.runasstrive.entity.Entity;

/**
 * Event which is called when an entity uses an ability.
 *
 * @author uvgsj
 * @version v0.1
 */
public class EntityAbilityUseEvent extends EntityEvent {

    private final EntityApplicable ability;

    /**
     * Creates a new ability use event.
     *
     * @param entity The entity which used the ability
     * @param ability The ability that has been used
     */
    public EntityAbilityUseEvent(Entity entity, EntityApplicable ability) {
        super(entity);
        this.ability = ability;
    }

    /**
     * Returns the ability that has been used.
     *
     * @return The ability that has been used
     */
    public EntityApplicable getAbility() {
        return this.ability;
    }
}
