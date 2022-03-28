package edu.kit.informatik.runasstrive.event.entity;

import edu.kit.informatik.runasstrive.ability.EntityApplicable;
import edu.kit.informatik.runasstrive.entity.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Event which is called when an ability was picked up by an entity.
 *
 * @author uvgsj
 * @version v0.1
 */
public class EntityAbilityGetEvent extends EntityEvent {

    private final List<EntityApplicable> abilities;

    /**
     * Creates a new entity ability get event.
     *
     * @param entity The entity which got the ability
     * @param abilities The abilities the entity got
     */
    public EntityAbilityGetEvent(Entity entity, List<EntityApplicable> abilities) {
        super(entity);

        this.abilities = new ArrayList<>(abilities);
    }

    /**
     * Returns the abilities the entity got.
     *
     * @return The abilities
     */
    public List<EntityApplicable> getAbilities() {
        return this.abilities;
    }
}