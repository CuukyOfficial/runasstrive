package edu.kit.informatik.runasstrive;

import edu.kit.informatik.runasstrive.stage.Team;

/**
 * Represents a level of the game.
 *
 * @author uvsgj
 * @version v0.1
 */
public interface Level {

    /**
     * Called if the stage of the level has ended.
     *
     * @param winner The winner of the stage
     */
    void onStageEnd(Team winner);

    /**
     * Starts the level.
     */
    void start();

    /**
     * Returns the number of the level.
     *
     * @return The number of the level
     */
    int getLevel();

}