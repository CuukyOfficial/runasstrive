package edu.kit.informatik.runasstrive.entity;

import edu.kit.informatik.runasstrive.ability.EntityApplicable;
import edu.kit.informatik.runasstrive.stage.Team;

import java.util.List;
import java.util.function.Consumer;

/**
 * Represents any behaviour used by an entity.
 * It contains various methods that will take a callback,
 * which will be executed if the behaviour received a response.
 *
 * @author uvgsj
 * @version v0.1
 */
public interface Behaviour {

    /**
     * Chooses an ability from the given options.
     *
     * @param consumer The ability consumer
     * @param options The given options
     */
    void chooseAbility(Consumer<EntityApplicable> consumer, EntityApplicable[] options);

    /**
     * Chooses an enemy from the given opponents.
     *
     * @param consumer The consumer of the opponent
     * @param opponents The given opponents
     */
    void chooseEnemy(Consumer<Entity> consumer, Team[] opponents);

    /**
     * Chooses a reward from the given loot.
     *
     * @param consumer The consumer of the chosen reward
     * @param loot The list of rewards to be chosen from
     * @param allowed The allowed amount of rewards
     */
    void chooseReward(Consumer<List<EntityApplicable>> consumer, List<EntityApplicable> loot, int allowed);

    /**
     * Chooses a die with a given max.
     *
     * @param dice The consumer of the die
     * @param max The max value of the die
     */
    void chooseDice(Consumer<Integer> dice, int max);

    /**
     * Chooses the abilities to be discarded to gain health.
     *
     * @param consumer The consumer of discarded abilities
     * @param abilities The abilities to be chosen from
     */
    void chooseHealDiscard(Consumer<List<EntityApplicable>> consumer, List<EntityApplicable> abilities);

    /**
     * Previews the next ability.
     *
     * @param options The options to be chosen from
     * @return The chosen option
     */
    EntityApplicable getNext(EntityApplicable[] options);

}