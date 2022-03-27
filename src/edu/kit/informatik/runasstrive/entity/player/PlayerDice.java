package edu.kit.informatik.runasstrive.entity.player;

public enum PlayerDice implements Dice {

    D12(null, 12),

    D10(D12, 10),
    D8(D10, 8),
    D6(D8, 6),
    D4(D6, 4);

    private static final String NAME_PREFIX = "d";

    private final String name;
    private final int max;
    private final Dice upgrade;

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