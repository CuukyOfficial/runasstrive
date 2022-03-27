package edu.kit.informatik.runasstrive;

import edu.kit.informatik.runasstrive.entity.EntityType;
import edu.kit.informatik.runasstrive.entity.player.Player;
import edu.kit.informatik.runasstrive.event.SubscriptionHolder;
import edu.kit.informatik.runasstrive.stage.Team;

/**
 * Represents a game which can be started and contains a player.
 * It will also take care of the events and can be
 *
 * @author uvsgj
 * @version v0.1
 */
public interface Game {

    /**
     * Starts the game with the given player type.
     *
     * @param playerType The type of the player
     */
    void start(EntityType playerType);

    /**
     * Tells the game that its level has ended.
     *
     * @param winner The winner of the level
     */
    void onLevelEnd(Team winner);

    /**
     * Returns the event manager of the game
     *
     * @return The event manager
     */
    SubscriptionHolder getEventManager();

    /**
     * Returns the player of the game.
     *
     * @return The player of the game
     */
    Player getPlayer();

}