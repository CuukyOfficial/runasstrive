package edu.kit.informatik.runasstrive.entity.player;

import edu.kit.informatik.runasstrive.entity.Entity;

public interface Player extends Entity {

    void upgradeDice();

    boolean canUpgradeDice();

}