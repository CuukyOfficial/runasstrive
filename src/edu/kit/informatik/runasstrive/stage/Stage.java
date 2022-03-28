package edu.kit.informatik.runasstrive.stage;

import edu.kit.informatik.runasstrive.Level;

/**
 * Represents a stage in a level.
 * It will take of the teams and that they'll take their turn.
 *
 * @author uvgsj
 * @version v0.1
 */
public interface Stage {

    /**
     * Starts the stage.
     */
    void start();

    /**
     * Lets the next team take their turn.
     */
    void next();

    /**
     * Checks if the stage is over.
     *
     * @return If the stage is over.
     */
    boolean isOver();

    /**
     * Gets the number of the stage.
     *
     * @return The number of the stage
     */
    int getStage();

    /**
     * Gets the level of the stage.
     *
     * @return The level of the stage
     */
    Level getLevel();

    /**
     * Gets the opponents of any team.
     *
     * @param team The team
     * @return The opponents
     */
    Team[] getOpponents(Team team);

    /**
     * Gets all teams in this stage.
     *
     * @return All the teams
     */
    Team[] getTeams();

}