package edu.kit.informatik.runasstrive.ability;

import edu.kit.informatik.runasstrive.ability.action.OffensiveAction;

public abstract class ReflectiveAbility extends DefensiveAbility {

    ReflectiveAbility(ApplicableType type, int level) {
        super(type, level);
    }

    protected abstract int getReflect(OffensiveAction action);

    @Override
    protected int getDefend(OffensiveAction action) {
        return this.getReflect(action);
    }

    @Override
    public int reflect(OffensiveAction action) {
        if (this.ignores(action)) return 0;
        return Math.min(action.getDamage(), this.getReflect(action));
    }
}