package edu.kit.informatik.runasstrive.entity;

import edu.kit.informatik.runasstrive.Game;
import edu.kit.informatik.runasstrive.ability.ApplicableType;
import edu.kit.informatik.runasstrive.ability.AttackData;
import edu.kit.informatik.runasstrive.ability.EntityApplicable;
import edu.kit.informatik.runasstrive.ability.RunaAbilityType;
import edu.kit.informatik.runasstrive.ability.action.AbilityActionType;
import edu.kit.informatik.runasstrive.ability.action.AbilityOffensiveSourceActionInfo;
import edu.kit.informatik.runasstrive.ability.action.AbilityOffensiveTargetActionInfo;
import edu.kit.informatik.runasstrive.ability.action.OffensiveTargetActionInfo;
import edu.kit.informatik.runasstrive.event.Event;
import edu.kit.informatik.runasstrive.event.entity.EntityAbilityGetEvent;
import edu.kit.informatik.runasstrive.event.entity.EntityAbilityUseEvent;
import edu.kit.informatik.runasstrive.event.entity.EntityDamageEvent;
import edu.kit.informatik.runasstrive.event.entity.EntityDeathEvent;
import edu.kit.informatik.runasstrive.event.entity.EntityFocusGainEvent;
import edu.kit.informatik.runasstrive.event.entity.EntityHealthGainEvent;
import edu.kit.informatik.runasstrive.event.entity.EntityTurnEvent;
import edu.kit.informatik.runasstrive.stage.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * Represents any entity of the game.
 * Handles all abilities, health and focus points.
 *
 * @author uvgsj
 * @version v0.1
 */
public abstract class LivingEntity implements Entity {

    private static final int HEALTH_PER_CARD = 10;

    private final Game game;
    private final EntityType type;
    private final List<EntityApplicable> abilities;
    private EntityApplicable holding;
    private final Behaviour behaviour;
    private int health;
    private int focus;

    /**
     * Creates a new living entity.
     * Health will be maxed out by default and default abilities
     * will be created with stage one.
     * Also, the focus points will be set to default
     * and it will create new behaviour.
     *
     * @param game The game of the entity
     * @param type The type of the entity
     */
    protected LivingEntity(Game game, EntityType type) {
        this.game = game;
        this.type = type;
        this.abilities = new ArrayList<>(type.getAbilities(1));
        this.behaviour = this.createBehaviour();
        this.health = this.type.getMaxHealth();
        this.focus = this.type.getStartFocus();
    }

    private void die() {
        this.game.getEventManager().notify(new EntityDeathEvent(this));
    }

    private void turn(Team team, Team[] opponents, EntityApplicable ability) {
        if (ability.getType().getAction() == AbilityActionType.OFFENSIVE) {
            this.behaviour.chooseEnemy(target -> this.attack(team, ability, target), opponents);
        } else {
            this.game.getEventManager().notify(new EntityAbilityUseEvent(this, ability));
            this.holding = ability;
            team.next();
        }
    }

    private void trade(Runnable onComplete, List<EntityApplicable> trade) {
        this.abilities.removeAll(trade);
        this.addHealth(trade.size() * HEALTH_PER_CARD);
        onComplete.run();
    }

    private void attack(Team team, EntityApplicable ability, Entity target) {
        this.game.getEventManager().notify(new EntityAbilityUseEvent(this, ability));
        if (!ability.getType().needsDice()) this.attack(team, ability, target, 0);
        else this.behaviour.chooseDice(dice -> this.attack(team, ability, target, dice), this.getMaxDice());
    }

    private void attack(Team team, EntityApplicable ability, Entity target, int dice) {
        AttackData attack = ability.attack(new AbilityOffensiveSourceActionInfo(this, target, this.focus, dice));
        target.damage(this, attack.getDamage(), ability.getType());
        if (attack.breaksFocus()) target.breakFocus();
        this.useAbility(ability);
        team.next();
    }

    private void useAbility(EntityApplicable ability) {
        this.addFocus(ability.getFocusChange());
    }

    private int calculateStatChange(int current, int max, int add, BiFunction<Entity, Integer, Event> event) {
        int finalAdd = Math.max(-current, Math.min(add, max - current));
        if (finalAdd > 0) this.game.getEventManager().notify(event.apply(this, finalAdd));
        return finalAdd;
    }

    private void addHealth(int add) {
        this.health += this.calculateStatChange(this.health, this.getMaxHealth(), add, EntityHealthGainEvent::new);
        if (this.health <= 0) this.die();
    }

    /**
     * Adds focus to the entity.
     *
     * @param focus The amount of focus
     */
    protected void addFocus(int focus) {
        this.focus += this.calculateStatChange(this.focus, this.getMaxFocus(), focus, EntityFocusGainEvent::new);
    }

    /**
     * Damages the entity.
     *
     * @param damage The amount of damage
     * @param attackType The type of attack
     * @return If any damage can be reflected
     */
    protected boolean damage(int damage, ApplicableType attackType) {
        this.game.getEventManager().notify(new EntityDamageEvent(this, attackType, damage));
        this.addHealth(-damage);
        return true;
    }

    /**
     * Gets the max die of the entity.
     *
     * @return The max die value
     */
    protected abstract int getMaxDice();

    /**
     * Creates new behaviour of the entity.
     *
     * @return The behaviour of the entity
     */
    protected abstract Behaviour createBehaviour();

    @Override
    public void reward(Consumer<List<EntityApplicable>> consumer, List<EntityApplicable> loot, int allowed) {
        this.behaviour.chooseReward(consumer, loot, allowed);
    }

    @Override
    public void heal(Runnable onHealComplete) {
        this.behaviour.chooseHealDiscard(list -> this.trade(onHealComplete, list), this.abilities);
    }

    @Override
    public void addAbilities(List<EntityApplicable> abilities) {
        this.game.getEventManager().notify(new EntityAbilityGetEvent(this, abilities));
        this.abilities.addAll(abilities);
    }

    @Override
    public void prepareTurn() {
        if (this.holding != null && this.holding.getType().getAction() == null) {
            this.useAbility(this.holding);
        }
        this.holding = null;
    }

    @Override
    public void turn(Team team, Team[] opponents) {
        this.game.getEventManager().notify(new EntityTurnEvent(this, team.getStage()));
        this.behaviour.chooseAbility(ability -> this.turn(team, opponents, ability),
            this.abilities.toArray(EntityApplicable[]::new));
    }

    @Override
    public void damage(Entity source, int damage, ApplicableType attackType) {
        int effective = damage;
        int reflective = 0;
        if (this.holding != null && this.holding.getType().getAction() == AbilityActionType.DEFENSIVE) {
            OffensiveTargetActionInfo action = new AbilityOffensiveTargetActionInfo(source, this, attackType, damage);
            effective -= this.holding.defend(action);
            reflective = this.holding.reflect(action);
            this.useAbility(this.holding);
        }

        if (effective > 0 && !this.damage(effective, attackType))
            return;

        if (reflective > 0)
            source.damage(this, reflective, this.holding.getType());
    }

    @Override
    public EntityType getType() {
        return this.type;
    }

    @Override
    public void breakFocus() {
        if (this.holding != null && this.holding.getType() == RunaAbilityType.FOCUS) this.holding = null;
    }

    @Override
    public int getFocus() {
        return this.focus;
    }

    @Override
    public int getMaxFocus() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean canPerform(EntityApplicable ability) {
        int change = ability.getFocusChange();
        return change >= 0 || Math.abs(change) <= this.focus;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getMaxHealth() {
        return this.type.getMaxHealth();
    }

    @Override
    public EntityApplicable getNext() {
        return this.behaviour.getNext(this.abilities.toArray(EntityApplicable[]::new));
    }

    @Override
    public Game getGame() {
        return this.game;
    }

    @Override
    public String toString() {
        return this.type.getName();
    }
}