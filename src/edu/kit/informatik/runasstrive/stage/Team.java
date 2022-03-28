package edu.kit.informatik.runasstrive.stage;

import edu.kit.informatik.runasstrive.entity.Entity;

/**
 * Represents a team of a stage which contains entities
 * and can take turn in a fight.
 *
 * @author uvgsj
 * @version v0.1
 */
public interface Team {

    /**
     * Returns if the entity is a member of this team.
     *
     * @param entity The entity to be checked
     * @return If the entity is in the team
     */
    boolean hasMember(Entity entity);

    /**
     * Returns if every member of the team is dead.
     *
     * @return If the team is dead
     */
    boolean isDead();

    /**
     * Lets every team member take turn
     */
    void turn();

    /**
     * Lets the next team member take turn
     */
    void next();

    /**
     * Returns the member of the team
     *
     * @return The member
     */
    Entity[] getMember();

    /**
     * Returns the stage of the team
     *
     * @return The stage of the team
     */
    Stage getStage();

}