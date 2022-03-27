package edu.kit.informatik.runasstrive.entity.player;

public interface Dice {

    int dice(int seed);

    int getMaxValue();

    Dice getUpgrade();

}