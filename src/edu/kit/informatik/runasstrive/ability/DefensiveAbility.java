package edu.kit.informatik.runasstrive.ability;

import edu.kit.informatik.runasstrive.ability.action.OffensiveTargetActionInfo;

/**
 * Represents any defensive ability.
 *
 * @author uvgsj
 * @version v0.1
 */
abstract class DefensiveAbility extends Ability {

    /**
     * Creates a new defensive ability.
     *
     * @param type The type of ability
     * @param level The level of the ability
     */
    DefensiveAbility(ApplicableType type, int level) {
        super(type, level);
    }

    /**
     * Returns how much damage has been blocked.
     *
     * @param action The offensive action
     * @return The amount of damage blocked
     */
    protected abstract int getDefend(OffensiveTargetActionInfo action);

    /**
     * Returns if the given action ignores this defense.
     *
     * @param action The action
     * @return If this will be ignored
     */
    protected boolean ignores(OffensiveTargetActionInfo action) {
        return !this.type.getSource().equals(action.getActionType().getSource());
    }

    @Override
    public int defend(OffensiveTargetActionInfo action) {
        if (this.ignores(action)) return 0;
        return this.getDefend(action);
    }

    @Override
    public int reflect(OffensiveTargetActionInfo action) {
        return 0;
    }
}