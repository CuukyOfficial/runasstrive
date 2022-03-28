package edu.kit.informatik.runasstrive.ability.action;

import edu.kit.informatik.runasstrive.entity.Entity;

/**
 * Represents any action performed by an ability.
 *
 * @author uvgsj
 * @version v0.1
 */
public class AbilityActionInfo implements ActionInfo {

    private final Entity source;
    private final Entity target;

    /**
     * Creates a new ability action.
     *
     * @param source The action source
     * @param target The action target
     */
    public AbilityActionInfo(Entity source, Entity target) {
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
