package edu.kit.informatik.runasstrive.ability;

import edu.kit.informatik.runasstrive.ability.action.OffensiveTargetActionInfo;

/**
 * Represents any reflective ability.
 *
 * @author uvgsj
 * @version v0.1
 */
abstract class ReflectiveAbility extends DefensiveAbility {

    /**
     * Creates any new reflective ability.
     *
     * @param type The type of the ability
     * @param level The level of the ability
     */
    ReflectiveAbility(ApplicableType type, int level) {
        super(type, level);
    }

    /**
     * Returns the amount of damage reflected.
     *
     * @param action The offensive action
     * @return The amount of damage reflected
     */
    protected abstract int getReflect(OffensiveTargetActionInfo action);

    @Override
    protected int getDefend(OffensiveTargetActionInfo action) {
        return this.getReflect(action);
    }

    @Override
    public int reflect(OffensiveTargetActionInfo action) {
        if (this.ignores(action)) return 0;
        return Math.min(action.getDamage(), this.getReflect(action));
    }
}