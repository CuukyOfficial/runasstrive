package edu.kit.informatik.runasstrive.ability.action;

import edu.kit.informatik.runasstrive.ability.ApplicableType;
import edu.kit.informatik.runasstrive.entity.Entity;

public class AbilityOffensiveAction extends AbilityAction implements OffensiveAction {

    private final ApplicableType actionType;
    private final int damage;

    public AbilityOffensiveAction(Entity source, Entity target, ApplicableType actionType, int damage) {
        super(source, target);

        this.actionType = actionType;
        this.damage = damage;
    }

    @Override
    public ApplicableType getActionType() {
        return this.actionType;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }
}