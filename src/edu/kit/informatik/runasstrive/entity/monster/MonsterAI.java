package edu.kit.informatik.runasstrive.entity.monster;

import edu.kit.informatik.runasstrive.ability.EntityApplicable;
import edu.kit.informatik.runasstrive.entity.Behaviour;
import edu.kit.informatik.runasstrive.entity.Entity;
import edu.kit.informatik.runasstrive.entity.SkipNoChoiceBehaviour;
import edu.kit.informatik.util.SaveIterator;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class MonsterAI extends SkipNoChoiceBehaviour implements Behaviour {

    private final Entity entity;
    private SaveIterator<EntityApplicable> iterator;

    public MonsterAI(Entity entity) {
        this.entity = entity;
    }

    private List<EntityApplicable> checkOptions(EntityApplicable[] options) {
        List<EntityApplicable> abilities = Arrays.stream(options).collect(Collectors.toList());
        if (this.iterator == null || !this.iterator.isEqual(abilities))
            this.iterator = new SaveIterator<>(abilities);
        return abilities;
    }

    @Override
    public void chooseAbility(Consumer<EntityApplicable> consumer, EntityApplicable[] options) {
        List<EntityApplicable> abilities = this.checkOptions(options);
        EntityApplicable chosen = this.iterator.next();
        if (!this.entity.canPerform(chosen))
            this.chooseAbility(consumer, options);
        else
            consumer.accept(chosen);
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
        this.checkOptions(options);
        return this.iterator.previewNext();
    }

    @Override
    public Entity getEntity() {
        return this.entity;
    }
}