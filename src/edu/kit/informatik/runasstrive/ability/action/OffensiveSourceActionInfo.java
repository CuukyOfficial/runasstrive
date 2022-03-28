package edu.kit.informatik.runasstrive.ability.action;

/**
 * Represents any offensive source action.
 * Contains focus points and dice.
 *
 * @author uvgsj
 * @version v0.1
 */
public interface OffensiveSourceActionInfo extends ActionInfo {

    /**
     * Returns the focus points.
     *
     * @return The focus points
     */
    int getFocusPoints();

    /**
     * Returns the dice of the action.
     *
     * @return The dice
     */
    int getDice();

}