package edu.kit.informatik.runasstrive.entity;

import edu.kit.informatik.runasstrive.ability.ApplicableType;
import edu.kit.informatik.runasstrive.ability.EntityApplicable;

import java.util.List;

/**
 * Represents the type of entity.
 * Contains various information about the entity.
 *
 * @author uvgsj
 * @version v0.1
 */
public interface EntityType {

    /**
     * Returns the name of the entity.
     *
     * @return The name
     */
    String getName();

    /**
     * Returns the max health of the entity.
     *
     * @return The max health of the entity
     */
    int getMaxHealth();

    /**
     * Returns the initial amount of focus of the entity.
     *
     * @return The initial amount of focus
     */
    int getStartFocus();

    /**
     * Returns the element of the entity.
     *
     * @return The element
     */
    EntityElement getElement();

    /**
     * Returns if the entity has the given default ability.
     *
     * @param type The ability to be checked
     * @return If the entity has the given default ability
     */
    boolean hasDefaultAbility(ApplicableType type);

    /**
     * Creates all the default abilities.
     *
     * @param stage The stage where the abilities are created in
     * @return The abilities
     */
    List<EntityApplicable> getAbilities(int stage);

}