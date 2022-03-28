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
        return 10 * this.level;
    }
}