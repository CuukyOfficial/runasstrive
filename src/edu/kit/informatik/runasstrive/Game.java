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
     * The given seeds will be used to shuffle the abilities and monsters.
     * The seed at index 0 will be used to shuffle the player abilities.
     * The seed at index 1 will be used to shuffle the monsters.
     *
     * @param playerType The type of the player
     * @param seeds The seeds that will be used to shuffle
     */
    void start(EntityType playerType, int[] seeds);

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