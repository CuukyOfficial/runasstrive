package edu.kit.informatik.runasstrive.entity.player;

/**
 * Represents any dice of the player.
 * It has a max value and can be upgraded.
 *
 * @author uvgsj
 * @version v0.1
 */
public interface Dice {

    /**
     * Returns the max dice value.
     *
     * @return The max dice value
     */
    int getMaxValue();

    /**
     * Returns the next dice upgrade
     *
     * @return The dice upgrade
     */
    Dice getUpgrade();

}