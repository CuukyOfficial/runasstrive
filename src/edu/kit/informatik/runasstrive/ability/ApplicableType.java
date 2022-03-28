package edu.kit.informatik.runasstrive.ability;

import edu.kit.informatik.runasstrive.ability.action.ActionType;
import edu.kit.informatik.runasstrive.entity.EntityElement;

/**
 * Represents the type of entity applicable.
 * It contains various information about the applicable,
 * such as name, action type, source type etc.
 *
 * @author uvgsj
 * @version v0.1
 */
public interface ApplicableType {

    /**
     * Returns the name of the applicable
     *
     * @return The name
     */
    String getName();

    /**
     * Returns the action of the applicable.
     *
     * @return The action
     */
    ActionType getAction();

    /**
     * Returns the source of the applicable.
     *
     * @return The source
     */
    ApplicableSource getSource();

    /**
     * Returns if the applicable needs a die.
     *
     * @return If a die is needed
     */
    boolean needsDice();

    /**
     * Returns the elements this applicable is effective against.
     *
     * @return The elements this applicable is effective against.
     */
    EntityElement[] getEffective();

    /**
     * Creates the matching applicable to this type with the given level.
     *
     * @param level The level
     * @return The applicable
     */
    EntityApplicable createAbility(int level);

}