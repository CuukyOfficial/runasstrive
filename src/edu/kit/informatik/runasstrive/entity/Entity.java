package edu.kit.informatik.runasstrive.entity;

import edu.kit.informatik.runasstrive.Game;
import edu.kit.informatik.runasstrive.ability.ApplicableType;
import edu.kit.informatik.runasstrive.ability.EntityApplicable;
import edu.kit.informatik.runasstrive.stage.Stage;
import edu.kit.informatik.runasstrive.stage.Team;

import java.util.List;
import java.util.function.Consumer;

public interface Entity {

    void damage(Entity source, int damage, ApplicableType attackType);

    void breakFocus();

    int getHealth();

    int getMaxHealth();

    int getFocus();

    int getMaxFocus();

    boolean canPerform(EntityApplicable ability);

    void prepareTurn();

    void turn(Stage stage, Team[] opponents);

    void reward(Consumer<List<EntityApplicable>> consumer, List<EntityApplicable> loot, int allowed);

    void heal(Runnable onHealComplete);

    void addAbilities(List<EntityApplicable> abilities);

    EntityApplicable getNext();

    EntityType getType();

    Game getGame();

}