package edu.kit.informatik.runasstrive.entity;

import edu.kit.informatik.runasstrive.ability.EntityApplicable;
import edu.kit.informatik.runasstrive.stage.Team;

import java.util.List;
import java.util.function.Consumer;

public interface Behaviour {

    void chooseAbility(Consumer<EntityApplicable> consumer, EntityApplicable[] options);

    void chooseEnemy(Consumer<Entity> consumer, Team[] opponents);

    void chooseReward(Consumer<List<EntityApplicable>> consumer, List<EntityApplicable> loot, int allowed);

    void chooseDice(Consumer<Integer> dice, int max);

    void chooseHealDiscard(Consumer<List<EntityApplicable>> consumer, List<EntityApplicable> abilities);

    EntityApplicable getNext(EntityApplicable[] options);

}