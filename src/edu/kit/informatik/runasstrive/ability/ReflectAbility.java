package edu.kit.informatik.runasstrive.ability;

import edu.kit.informatik.runasstrive.ability.action.OffensiveTargetActionInfo;

/**
 * Represents the reflect ability.
 * Reflects 10 * n damage.
 *
 * @author uvgsj
 * @version v0.1
 */
class ReflectAbility extends ReflectiveAbility {

    private static final int REFLECT_MULTIPLIER = 10;

    /**
     * Creates a new ability with the given level.
     *
     * @param level The level
     */
    ReflectAbility(int level) {
        super(RunaAbilityType.REFLECT, level);
    }

    @Override
    protected int getReflect(OffensiveTargetActionInfo action) {
        return REFLECT_MULTIPLIER * this.level;
    }
}