package edu.kit.informatik.runasstrive.event.entity;

import edu.kit.informatik.runasstrive.entity.player.Dice;
import edu.kit.informatik.runasstrive.entity.player.Player;

/**
 * Event which will be called when a player upgrades his dice.
 *
 * @author uvgsj
 * @version v0.1
 */
public class PlayerDiceUpgradeEvent extends EntityEvent {

    private final Dice upgrade;

    /**
     * Creates a new player dice upgrade event.
     *
     * @param entity The player that upgraded his dice
     * @param upgrade The upgrade
     */
    public PlayerDiceUpgradeEvent(Player entity, Dice upgrade) {
        super(entity);

        this.upgrade = upgrade;
    }

    /**
     * Returns the upgrade.
     *
     * @return The upgrade
     */
    public Dice getUpgrade() {
        return this.upgrade;
    }
}