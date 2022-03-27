package edu.kit.informatik.runasstrive.entity;

import edu.kit.informatik.runasstrive.ability.EntityApplicable;
import edu.kit.informatik.runasstrive.stage.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public abstract class SkipNoChoiceBehaviour implements Behaviour {

    @Override
    public void chooseEnemy(Consumer<Entity> consumer, Team[] opponents) {
        List<Entity> entities = Arrays.stream(opponents).map(Team::getMember)
            .flatMap(Arrays::stream).collect(Collectors.toList());
        if (entities.size() == 1) consumer.accept(entities.get(0));
        else this.chooseSaveEnemy(consumer, entities);
    }

    @Override
    public void chooseAbility(Consumer<EntityApplicable> consumer, EntityApplicable[] options) {
        if (options.length == 1) consumer.accept(options[0]);
        else this.chooseSaveAbility(consumer, options);
    }

    @Override
    public void chooseHealDiscard(Consumer<List<EntityApplicable>> consumer, List<EntityApplicable> abilities) {
        if (abilities.size() <= 1 || this.getEntity().getHealth() == this.getEntity().getMaxHealth())
            consumer.accept(new ArrayList<>());
        else this.chooseSaveHealDiscard(consumer, abilities);
    }

    public abstract void chooseSaveEnemy(Consumer<Entity> consumer, List<Entity> enemies);

    public abstract void chooseSaveAbility(Consumer<EntityApplicable> consumer, EntityApplicable[] options);

    public abstract void chooseSaveHealDiscard(Consumer<List<EntityApplicable>> consumer,
                                               List<EntityApplicable> abilities);

    public abstract Entity getEntity();
}
