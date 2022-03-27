package edu.kit.informatik.runasstrive.entity.player;

import edu.kit.informatik.runasstrive.ability.EntityApplicable;
import edu.kit.informatik.runasstrive.entity.Behaviour;

import java.util.List;
import java.util.function.Consumer;

/**
 * Beha
 *
 * @author uvgsj
 * @version v0.1
 */
public interface PlayerBehaviour extends Behaviour {

    void chooseLoot(Consumer<List<EntityApplicable>> consumer, List<EntityApplicable> loot, int allowed);

    void upgradeDice();

}