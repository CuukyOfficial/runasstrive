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

    void start(EntityType playerType, int[] seeds);

    void onLevelEnd(Team winner);

    SubscriptionHolder getEventManager();

    Player getPlayer();

}