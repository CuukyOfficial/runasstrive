package edu.kit.informatik.runasstrive.ability;

import edu.kit.informatik.runasstrive.ability.action.OffensiveSourceActionInfo;
import edu.kit.informatik.runasstrive.ability.action.OffensiveTargetActionInfo;

/**
 * Represents an ability.
 * It contains a type and a level.
 * For more information see @{@link EntityApplicable}.
 *
 * @author uvgsj
 * @version v0.1
 */
public class Ability implements EntityApplicable {

    /**
     * The type of the ability
     */
    protected final ApplicableType type;
    /**
     * The level of the ability
     */
    protected final int level;

    /**
     * Creates new ability with a given type and level.
     *
     * @param type The type
     * @param level The level
     */
    Ability(ApplicableType type, int level) {
        this.type = type;
        this.level = level;
    }

    @Override
    public int getFocusChange() {
        return 0;
    }

    @Override
    public AttackData attack(OffensiveSourceActionInfo action) {
        throw new UnsupportedOperationException("This ability does not attack!");
    }

    @Override
    public int defend(OffensiveTargetActionInfo action) {
        throw new UnsupportedOperationException("This ability does not defend!");
    }

    @Override
    public int reflect(OffensiveTargetActionInfo action) {
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