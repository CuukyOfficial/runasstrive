package edu.kit.informatik.runasstrive.ability;

import edu.kit.informatik.runasstrive.ability.action.OffensiveTargetActionInfo;

/**
 * Represents the block ability.
 * Blocks 7 * n damage.
 *
 * @author uvgsj
 * @version v0.1
 */
class BlockAbility extends DefensiveAbility {

    /**
     * Creates a new ability with the given level.
     *
     * @param level The level
     */
    BlockAbility(int level) {
        super(MonsterAbilityType.BLOCK, level);
    }

    @Override
    protected int getDefend(OffensiveTargetActionInfo action) {
        return 7 * this.level;
    }
}