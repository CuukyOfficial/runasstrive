package edu.kit.informatik.runasstrive.ability.action;

import edu.kit.informatik.runasstrive.entity.Entity;

public class AbilityDefensiveAction extends AbilityAction implements DefensiveAction {

    private final int focusPoints;
    private final int dice;

    public AbilityDefensiveAction(Entity source, Entity target, int focusPoints, int dice) {
        super(source, target);

        this.focusPoints = focusPoints;
        this.dice = dice;
    }

    @Override
    public int getFocusPoints() {
        return this.focusPoints;
    }

    @Override
    public int getDice() {
        return this.dice;
    }
}