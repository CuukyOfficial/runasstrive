package edu.kit.informatik.runasstrive.entity;

import edu.kit.informatik.runasstrive.Game;
import edu.kit.informatik.runasstrive.ability.ApplicableType;
import edu.kit.informatik.runasstrive.ability.EntityApplicable;
import edu.kit.informatik.runasstrive.stage.Team;

import java.util.List;
import java.util.function.Consumer;

/**
 * Represents any entity that can be used to play the game.
 *
 * @author uvgsj
 * @version v0.1
 */
public interface Entity {

    /**
     * Damages the entity.
     * Health will not decrease lower than 0
     * or increase higher than Entity#getMaxHealth.
     *
     * @param source The source of the damage
     * @param damage The amount of damage
     * @param attackType The type of attack
     */
    void damage(Entity source, int damage, ApplicableType attackType);

    /**
     * Breaks the focus of this entity.
     */
    void breakFocus();

    /**
     * Returns the health of the entity.
     *
     * @return The health
     */
    int getHealth();

    /**
     * Returns the max health of the entity.
     *
     * @return The max health
     */
    int getMaxHealth();

    /**
     * Returns the focus points of the entity.
     *
     * @return The focus points
     */
    int getFocus();

    /**
     * Returns the maximum focus points of the entity.
     *
     * @return The max focus points
     */
    int getMaxFocus();

    /**
     * Returns if the given ability can be performed.
     *
     * @param ability The ability to be checked
     * @return If the ability can be performed
     */
    boolean canPerform(EntityApplicable ability);

    /**
     * Prepares for the next turn.
     */
    void prepareTurn();

    /**
     * Lets the entity do its turn.
     *
     * @param team The team of the entity
     * @param opponents The opponents of the entity
     */
    void turn(Team team, Team[] opponents);

    /**
     * Rewards the entity. It will choose the amount of allowed
     * cards from the given loot list.
     *
     * @param consumer The consumer of the chosen loot
     * @param loot The available loot
     * @param allowed The maximum allowed amount of loot
     */
    void reward(Consumer<List<EntityApplicable>> consumer, List<EntityApplicable> loot, int allowed);

    /**
     * Lets the entity heal with his abilities.
     *
     * @param onHealComplete Runnable to be called if the healing process is complete.
     */
    void heal(Runnable onHealComplete);

    /**
     * Adds abilities to the entity.
     *
     * @param abilities The abilities to be added
     */
    void addAbilities(List<EntityApplicable> abilities);

    /**
     * Gets the next ability the entity will use.
     *
     * @return The ability the entity will use
     */
    EntityApplicable getNext();

    /**
     * Returns the type of the entity.
     *
     * @return The type of the entity
     */
    EntityType getType();

    /**
     * Returns the game of the entity
     *
     * @return The game of the entity
     */
    Game getGame();

}