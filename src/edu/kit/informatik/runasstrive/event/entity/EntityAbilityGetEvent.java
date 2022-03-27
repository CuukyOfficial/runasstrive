package edu.kit.informatik.runasstrive.event.entity;

import edu.kit.informatik.runasstrive.ability.EntityApplicable;
import edu.kit.informatik.runasstrive.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public class EntityAbilityGetEvent extends EntityEvent {

    private final List<EntityApplicable> abilities;

    public EntityAbilityGetEvent(Entity entity, List<EntityApplicable> abilities) {
        super(entity);

        this.abilities = new ArrayList<>(abilities);
    }

    public List<EntityApplicable> getAbilities() {
        return this.abilities;
    }
}