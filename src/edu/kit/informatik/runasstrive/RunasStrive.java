package edu.kit.informatik.runasstrive;

import edu.kit.informatik.runasstrive.entity.EntityType;
import edu.kit.informatik.runasstrive.entity.player.EntityPlayer;
import edu.kit.informatik.runasstrive.entity.player.Player;
import edu.kit.informatik.runasstrive.event.EventHandler;
import edu.kit.informatik.runasstrive.event.GameEndEvent;
import edu.kit.informatik.runasstrive.event.SubscriptionHolder;
import edu.kit.informatik.runasstrive.stage.Team;

/**
 *
 * The main game class.
 * It will initiate the player and start the levels.
 *
 * @author uvgsj
 * @version v0.1
 */
public class RunasStrive implements Game {

    private static final int MAX_LEVELS = 2;

    private final SubscriptionHolder eventHandler;
    private Player player;
    private int[] seeds;
    private Level level;

    public RunasStrive() {
        this.eventHandler = new EventHandler();
    }

    private void startLevel(int level) {
        this.level = new RunasStriveLevel(this, level);
        this.level.start(this.seeds);
    }

    @Override
    public void start(EntityType playerType, int[] seeds) {
        this.player = new EntityPlayer(this, playerType);
        this.seeds = seeds;
        this.startLevel(1);
    }

    @Override
    public void onLevelEnd(Team winner) {
        if (this.level.getLevel() >= MAX_LEVELS || !winner.hasMember(player))
            this.eventHandler.notify(new GameEndEvent(winner));
        else {
            this.player.addAbilities(this.player.getType().getAbilities(this.level.getLevel() + 1));
            this.player.heal(() -> this.startLevel(this.level.getLevel() + 1));
        }
    }

    @Override
    public SubscriptionHolder getEventManager() {
        return this.eventHandler;
    }

    @Override
    public Player getPlayer() {
        return this.player;
    }
}