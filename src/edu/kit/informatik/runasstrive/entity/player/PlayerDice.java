package edu.kit.informatik.runasstrive.entity.player;

/**
 * Represents all dices of the player.
 *
 * @author uvgsj
 * @version v0.1
 */
public enum PlayerDice implements Dice {

    /**
     * D12 die, the highest die
     */
    D12(null, 12),
    /**
     * D10 die
     */
    D10(D12, 10),
    /**
     * D8 die
     */
    D8(D10, 8),
    /**
     * D6 die
     */
    D6(D8, 6),
    /**
     * D4 die
     */
    D4(D6, 4);

    private static final String NAME_PREFIX = "d";

    private final String name;
    private final int max;
    private final Dice upgrade;

    /**
     * Creates a new dice.
     *
     * @param upgrade The next dice
     * @param max The max value of the dice
     */
    PlayerDice(Dice upgrade, int max) {
        this.name = NAME_PREFIX + max;
        this.max = max;
        this.upgrade = upgrade;
    }

    @Override
    public int getMaxValue() {
        return this.max;
    }

    @Override
    public Dice getUpgrade() {
        return this.upgrade;
    }

    @Override
    public String toString() {
        return this.name;
    }
}