package edu.kit.informatik.runasstrive.entity.monster;

import edu.kit.informatik.runasstrive.ability.EntityApplicable;
import edu.kit.informatik.runasstrive.entity.Behaviour;
import edu.kit.informatik.runasstrive.entity.Entity;
import edu.kit.informatik.runasstrive.entity.SkipNoChoiceBehaviour;
import edu.kit.informatik.util.NumberUtils;

import java.util.List;
import java.util.function.Consumer;

public class MonsterAI extends SkipNoChoiceBehaviour implements Behaviour {

    private final Entity entity;
    private int lastAbility = 0;

    public MonsterAI(Entity entity) {
        this.entity = entity;
    }

    @Override
    public void chooseSaveAbility(Consumer<EntityApplicable> consumer, EntityApplicable[] options) {
        int last = this.lastAbility;
        this.lastAbility = NumberUtils.getNext(this.lastAbility, options.length);
        if (!this.entity.canPerform(options[last]))
            this.chooseAbility(consumer, options);
        else
            consumer.accept(options[last]);
    }

    @Override
    public void chooseSaveEnemy(Consumer<Entity> consumer, List<Entity> enemies) {
        throw new UnsupportedOperationException("Monsters don't know how to combat against multiple enemies");
    }

    @Override
    public void chooseSaveHealDiscard(Consumer<List<EntityApplicable>> consumer, List<EntityApplicable> abilities) {
        throw new UnsupportedOperationException("Monsters don't know how to heal");
    }

    @Override
    public void chooseDice(Consumer<Integer> dice, int max) {
        throw new UnsupportedOperationException("Monsters don't know how to dice");
    }

    @Override
    public void chooseReward(Consumer<List<EntityApplicable>> consumer, List<EntityApplicable> loot, int allowed) {
        throw new UnsupportedOperationException("Monsters don't know how to choose a reward");
    }

    @Override
    public EntityApplicable getNext(EntityApplicable[] options) {
        return options[this.lastAbility];
    }

    @Override
    public Entity getEntity() {
        return this.entity;
    }
}