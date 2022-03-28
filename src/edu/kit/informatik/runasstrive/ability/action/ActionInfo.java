package edu.kit.informatik.runasstrive.ability.action;

import edu.kit.informatik.runasstrive.entity.Entity;

/**
 * Represents any action performed.
 * Contains source and target.
 *
 * @author uvgsj
 * @version v0.1
 */
public interface ActionInfo {

    /**
     * Returns the action source.
     *
     * @return The action source
     */
    Entity getSource();

    /**
     * Returns the action target
     *
     * @return The action target
     */
    Entity getTarget();

}