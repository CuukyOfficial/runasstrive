package edu.kit.informatik.runasstrive.ability;

import edu.kit.informatik.runasstrive.ability.action.OffensiveAction;

class BlockAbility extends DefensiveAbility {

    BlockAbility(int level) {
        super(MonsterAbilityType.BLOCK, level);
    }

    @Override
    protected int getDefend(OffensiveAction action) {
        return 7 * this.level;
    }
}