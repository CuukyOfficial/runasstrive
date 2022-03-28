package edu.kit.informatik.runasstrive.ability;

import edu.kit.informatik.runasstrive.ability.action.OffensiveTargetActionInfo;

/**
 * Represents parry ability.
 * Blocks 7 * n damage.
 *
 * @author uvgsj
 * @version v0.1
 */
class ParryAbility extends DefensiveAbility {

    /**
     * Creates a new ability with the given level.
     *
     * @param level The level
     */
    ParryAbility(int level) {
        super(RunaAbilityType.PARRY, level);
    }

    @Override
    protected int getDefend(OffensiveTargetActionInfo action) {
        return 7 * this.level;
    }
}