package edu.kit.informatik.runasstrive.entity.player;

import java.util.Random;
import java.util.stream.IntStream;

public enum GameDice implements Dice {

    D12(null, 12),
    D10(D12, 10),
    D8(D10, 8),
    D6(D8, 6),
    D4(D6, 4);

    private final int[] numbers;
    private final int max;
    private final Dice upgrade;

    GameDice(Dice upgrade, int max) {
        this.numbers = IntStream.rangeClosed(1, max).toArray();
        this.max = max;
        this.upgrade = upgrade;
    }

    @Override
    public int dice(int seed) {
        int random = new Random(seed).nextInt(this.numbers.length);
        return this.numbers[random];
    }

    @Override
    public int getMaxValue() {
        return this.max;
    }

    @Override
    public Dice getUpgrade() {
        return this.upgrade;
    }
}