package edu.kit.informatik.runasstrive.entity.monster;

import edu.kit.informatik.runasstrive.Game;
import edu.kit.informatik.runasstrive.entity.Behaviour;
import edu.kit.informatik.runasstrive.entity.LivingEntity;

/**
 * Represents a game monster.
 * It won't dice.
 *
 * @author uvgsj
 * @version v0.1
 */
public class Monster extends LivingEntity {

    /**
     * Creates a new monster.
     *
     * @param game The game of the monster
     * @param type The type of the monster
     */
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