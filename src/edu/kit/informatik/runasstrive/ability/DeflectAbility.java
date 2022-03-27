package edu.kit.informatik.runasstrive.ability;

import edu.kit.informatik.runasstrive.ability.action.OffensiveAction;

class DeflectAbility extends DefensiveAbility {

    DeflectAbility(int level) {
        super(MonsterAbilityType.DEFLECT, level);
    }

    @Override
    protected int getDefend(OffensiveAction action) {
        return 11 * this.level + 2;
    }
}