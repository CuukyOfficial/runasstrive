package edu.kit.informatik.runasstrive.ability.action;

import edu.kit.informatik.runasstrive.entity.Entity;

public class AbilityAction implements Action {

    private final Entity source;
    private final Entity target;

    public AbilityAction(Entity source, Entity target) {
        this.source = source;
        this.target = target;
    }

    @Override
    public Entity getSource() {
        return this.source;
    }

    @Override
    public Entity getTarget() {
        return this.target;
    }
}
