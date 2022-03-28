package edu.kit.informatik.runasstrive.ability;

import edu.kit.informatik.runasstrive.ability.action.OffensiveTargetActionInfo;

/**
 * Represents the deflect ability.
 * Blocks 11 * n + 2 damage.
 *
 * @author uvgsj
 * @version v0.1
 */
class DeflectAbility extends DefensiveAbility {

    /**
     * Creates a new ability with the given level.
     *
     * @param level The level
     */
    DeflectAbility(int level) {
        super(MonsterAbilityType.DEFLECT, level);
    }

    @Override
    protected int getDefend(OffensiveTargetActionInfo action) {
        return 11 * this.level + 2;
    }
}