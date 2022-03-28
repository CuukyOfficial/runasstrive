package edu.kit.informatik.runasstrive.entity.player;

import edu.kit.informatik.runasstrive.ability.EntityApplicable;
import edu.kit.informatik.runasstrive.entity.Behaviour;

import java.util.List;
import java.util.function.Consumer;

/**
 * Behaviour of the player.
 *
 * @author uvgsj
 * @version v0.1
 */
public interface PlayerBehaviour extends Behaviour {

    /**
     * Chooses a given amount of loot from the given list.
     *
     * @param consumer The consumer of the chosen loot
     * @param loot The given list of loot
     * @param allowed The maximum allowed of loot
     */
    void chooseLoot(Consumer<List<EntityApplicable>> consumer, List<EntityApplicable> loot, int allowed);

    /**
     * Upgrades the dice.
     */
    void upgradeDice();

}