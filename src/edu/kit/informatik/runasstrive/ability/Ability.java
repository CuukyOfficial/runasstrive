package edu.kit.informatik.runasstrive.ability;

import edu.kit.informatik.runasstrive.ability.action.DefensiveAction;
import edu.kit.informatik.runasstrive.ability.action.OffensiveAction;

public class Ability implements EntityApplicable {

    protected final ApplicableType type;
    protected final int level;

    Ability(ApplicableType type, int level) {
        this.type = type;
        this.level = level;
    }

    @Override
    public int getFocusChange() {
        return 0;
    }

    @Override
    public AttackData attack(DefensiveAction action) {
        throw new UnsupportedOperationException("This ability does not attack!");
    }

    @Override
    public int defend(OffensiveAction action) {
        throw new UnsupportedOperationException("This ability does not defend!");
    }

    @Override
    public int reflect(OffensiveAction action) {
        return this.defend(action);
    }

    @Override
    public ApplicableType getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return this.type.getName() + "(" + this.level + ")";
    }
}