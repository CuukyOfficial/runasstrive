package edu.kit.informatik.runasstrive.entity.player;

import edu.kit.informatik.runasstrive.entity.Entity;

/**
 * Represents the player of the game.
 * It contains a die in addition to everything
 * an @{@link Entity} is able to do.
 *
 * @author uvgsj
 * @version v0.1
 */
public interface Player extends Entity {

    /**
     * Upgrades the players die.
     */
    void upgradeDice();

    /**
     * If the die of the player can be upgraded.
     *
     * @return If the die can be upgraded
     */
    boolean canUpgradeDice();

}