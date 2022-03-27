package edu.kit.informatik.runasstrive.entity.monster;

import edu.kit.informatik.runasstrive.Game;
import edu.kit.informatik.runasstrive.entity.Behaviour;
import edu.kit.informatik.runasstrive.entity.LivingEntity;

public class Monster extends LivingEntity {

    public Monster(Game game, MonsterType type) {
        super(game, type);
    }

    @Override
    protected Behaviour createBehaviour() {
        return new MonsterAI(this);
    }

    @Override
    protected int getMaxDice() {
        return 0;
    }
}