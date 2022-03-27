package edu.kit.informatik.runasstrive.event.entity;

import edu.kit.informatik.runasstrive.entity.Entity;
import edu.kit.informatik.runasstrive.entity.player.Dice;

public class PlayerDiceUpgradeEvent extends EntityEvent {

    private final Dice upgrade;

    public PlayerDiceUpgradeEvent(Entity entity, Dice upgrade) {
        super(entity);

        this.upgrade = upgrade;
    }

    public Dice getUpgrade() {
        return this.upgrade;
    }
}