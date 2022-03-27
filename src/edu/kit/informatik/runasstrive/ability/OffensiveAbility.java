package edu.kit.informatik.runasstrive.ability;

import edu.kit.informatik.runasstrive.ability.action.DefensiveAction;
import edu.kit.informatik.runasstrive.entity.Entity;

import java.util.Arrays;

abstract class OffensiveAbility extends Ability {

    OffensiveAbility(ApplicableType type, int level) {
        super(type, level);
    }

    private boolean isEffectiveAgainst(Entity entity) {
        return Arrays.asList(this.type.getEffective()).contains(entity.getType().getElement());
    }

    abstract int getDamage(int focus, int dice);

    int getEffectiveAddition(int focus, int dice) {
        return 0;
    }

    boolean breaksFocus() {
        return false;
    }

    @Override
    public final AttackData attack(DefensiveAction action) {
        int damage = this.getDamage(action.getFocusPoints(), action.getDice());
        if (this.isEffectiveAgainst(action.getTarget()))
            damage += this.getEffectiveAddition(action.getFocusPoints(), action.getDice());
        return new AbilityAttackData(damage, this.breaksFocus());
    }
}