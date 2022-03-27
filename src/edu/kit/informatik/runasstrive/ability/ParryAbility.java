package edu.kit.informatik.runasstrive.ability;

import edu.kit.informatik.runasstrive.ability.action.OffensiveAction;

class ParryAbility extends DefensiveAbility {

    ParryAbility(int level) {
        super(RunaAbilityType.PARRY, level);
    }

    @Override
    protected int getDefend(OffensiveAction action) {
        return 7 * this.level;
    }
}