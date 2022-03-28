package edu.kit.informatik.runasstrive.entity;

import edu.kit.informatik.runasstrive.ability.EntityApplicable;
import edu.kit.informatik.runasstrive.stage.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Represents behaviour where every choice where
 * the choice cannot be made due to obvious reasons, will be executed automatically.
 *
 * @author uvgsj
 * @version v0.1
 */
public abstract class SkipNoChoiceBehaviour implements Behaviour {

    @Override
    public void chooseEnemy(Consumer<Entity> consumer, Team[] opponents) {
        List<Entity> entities = Arrays.stream(opponents).map(Team::getMember)
            .flatMap(Arrays::stream).collect(Collectors.toList());
        if (entities.size() == 1) consumer.accept(entities.get(0));
        else this.chooseSaveEnemy(consumer, entities);
    }

    @Override
    public void chooseHealDiscard(Consumer<List<EntityApplicable>> consumer, List<EntityApplicable> abilities) {
        if (abilities.size() <= 1 || this.getEntity().getHealth() == this.getEntity().getMaxHealth())
            consumer.accept(new ArrayList<>());
        else this.chooseSaveHealDiscard(consumer, abilities);
    }

    /**
     * Chooses an enemy from the given opponents.
     * The amount of enemies in this list will never be one.
     *
     * @param consumer The consumer of the opponent
     * @param enemies The given opponents
     */
    public abstract void chooseSaveEnemy(Consumer<Entity> consumer, List<Entity> enemies);

    /**
     * Chooses the abilities to be discarded to gain health.
     * The amount of abilities will never be equal or less than one.
     * Furthermore, this method will not be executed if the entity
     * is already at full health.
     *
     * @param consumer The consumer of discarded abilities
     * @param abilities The abilities to be chosen from
     */
    public abstract void chooseSaveHealDiscard(Consumer<List<EntityApplicable>> consumer,
                                               List<EntityApplicable> abilities);

    /**
     * Returns the entity of the behaviour.
     *
     * @return The entity
     */
    public abstract Entity getEntity();
}
