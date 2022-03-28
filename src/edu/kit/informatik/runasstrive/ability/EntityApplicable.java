package edu.kit.informatik.runasstrive.ability;

import edu.kit.informatik.runasstrive.ability.action.OffensiveSourceActionInfo;
import edu.kit.informatik.runasstrive.ability.action.OffensiveTargetActionInfo;

/**
 * Represents anything that can be applied to an entity.
 * It can change its focus, attack, defend or reflect.
 *
 * @author uvgsj
 * @version v0.1
 */
public interface EntityApplicable {

    /**
     * Returns the focus change.
     *
     * @return The focus change
     */
    int getFocusChange();

    /**
     * Returns the attack data to the given action.
     *
     * @param action The action
     * @return The attack data
     */
    AttackData attack(OffensiveSourceActionInfo action);

    /**
     * Returns the amount of damage blocked
     *
     * @param action The offensive action performed
     * @return The amount of damage blocked
     */
    int defend(OffensiveTargetActionInfo action);

    /**
     * Returns the amount of damage reflected
     *
     * @param action The offensive action performed
     * @return The amount of damage reflected
     */
    int reflect(OffensiveTargetActionInfo action);

    /**
     * Returns the type of the entity applicable.
     *
     * @return The type
     */
    ApplicableType getType();

}