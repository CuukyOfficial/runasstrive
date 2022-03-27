package edu.kit.informatik.runasstrive.ability;

import edu.kit.informatik.runasstrive.ability.action.OffensiveAction;

class ReflectAbility extends ReflectiveAbility {

    ReflectAbility(int level) {
        super(RunaAbilityType.REFLECT, level);
    }

    @Override
    protected int getReflect(OffensiveAction action) {
        return this.level * 10;
    }
}