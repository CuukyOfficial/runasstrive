package edu.kit.informatik.runasstrive.ability.action;

import edu.kit.informatik.runasstrive.ability.ApplicableType;
import edu.kit.informatik.runasstrive.entity.Entity;

/**
 * Represents any offensive target action.
 * For more see {@link OffensiveTargetActionInfo}.
 *
 * @author uvgsj
 * @version v0.1
 */
public class AbilityOffensiveTargetActionInfo extends AbilityActionInfo implements OffensiveTargetActionInfo {

    private final ApplicableType actionType;
    private final int damage;

    /**
     * Creates new offensive target action.
     *
     * @param source The source
     * @param target The target
     * @param actionType The action type
     * @param damage The damage
     */
    public AbilityOffensiveTargetActionInfo(Entity source, Entity target, ApplicableType actionType, int damage) {
        super(source, target);

        this.actionType = actionType;
        this.damage = damage;
    }

    @Override
    public ApplicableType getActionType() {
        return this.actionType;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }
}