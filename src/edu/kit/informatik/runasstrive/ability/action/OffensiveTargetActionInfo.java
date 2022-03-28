package edu.kit.informatik.runasstrive.ability.action;

import edu.kit.informatik.runasstrive.ability.ApplicableType;

/**
 * Represents any offensive target action.
 * Contains action type and damage dealt by the action.
 *
 * @author uvgsj
 * @version v0.1
 */
public interface OffensiveTargetActionInfo extends ActionInfo {

    /**
     * Returns the action type of the action.
     *
     * @return The action type.
     */
    ApplicableType getActionType();

    /**
     * Returns the damage of the action.
     *
     * @return The damage.
     */
    int getDamage();

}