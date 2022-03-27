package edu.kit.informatik.runasstrive.ability;

import edu.kit.informatik.runasstrive.ability.action.OffensiveAction;

abstract class DefensiveAbility extends Ability {

    DefensiveAbility(ApplicableType type, int level) {
        super(type, level);
    }

    protected abstract int getDefend(OffensiveAction action);

    protected boolean ignores(OffensiveAction action) {
        return !this.type.getSource().equals(action.getActionType().getSource());
    }

    @Override
    public int defend(OffensiveAction action) {
        if (this.ignores(action)) return 0;
        return this.getDefend(action);
    }

    @Override
    public int reflect(OffensiveAction action) {
        return 0;
    }
}