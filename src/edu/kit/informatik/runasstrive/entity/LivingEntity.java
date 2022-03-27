package edu.kit.informatik.runasstrive.entity;

import edu.kit.informatik.runasstrive.Game;
import edu.kit.informatik.runasstrive.ability.ApplicableType;
import edu.kit.informatik.runasstrive.ability.AttackData;
import edu.kit.informatik.runasstrive.ability.EntityApplicable;
import edu.kit.informatik.runasstrive.ability.RunaAbilityType;
import edu.kit.informatik.runasstrive.ability.action.AbilityActionType;
import edu.kit.informatik.runasstrive.ability.action.AbilityDefensiveAction;
import edu.kit.informatik.runasstrive.ability.action.AbilityOffensiveAction;
import edu.kit.informatik.runasstrive.ability.action.OffensiveAction;
import edu.kit.informatik.runasstrive.event.entity.EntityAbilityGetEvent;
import edu.kit.informatik.runasstrive.event.entity.EntityAbilityUseEvent;
import edu.kit.informatik.runasstrive.event.entity.EntityDamageEvent;
import edu.kit.informatik.runasstrive.event.entity.EntityDeathEvent;
import edu.kit.informatik.runasstrive.event.entity.EntityFocusGainEvent;
import edu.kit.informatik.runasstrive.event.entity.EntityHealthGainEvent;
import edu.kit.informatik.runasstrive.event.entity.EntityTurnEvent;
import edu.kit.informatik.runasstrive.stage.Stage;
import edu.kit.informatik.runasstrive.stage.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class LivingEntity implements Entity {

    private final Game game;
    private final EntityType type;
    private final List<EntityApplicable> abilities;
    private EntityApplicable holding;
    private final Behaviour behaviour;
    private int health;
    private int focus;

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

    private void damage(int damage, ApplicableType attackType) {
        this.game.getEventManager().notify(new EntityDamageEvent(this, attackType, damage));
        this.addHealth(-damage);
    }

    private void turn(Stage stage, Team[] opponents, EntityApplicable ability) {
        this.game.getEventManager().notify(new EntityAbilityUseEvent(this, ability));
        if (ability.getType().getAction() == AbilityActionType.OFFENSIVE) {
            this.behaviour.chooseEnemy(target -> this.attack(stage, ability, target), opponents);
        } else {
            this.holding = ability;
            stage.next();
        }
    }

    private void addHealth(int add) {
        if (add > 0) this.game.getEventManager().notify(new EntityHealthGainEvent(this, add));
        this.health = Math.max(0, Math.min(this.health + add, this.getMaxHealth()));
        if (this.health == 0) this.die();
    }

    private void trade(Runnable onComplete, List<EntityApplicable> trade) {
        this.abilities.removeAll(trade);
        this.addHealth(trade.size() * 10);
        onComplete.run();
    }

    private void attack(Stage stage, EntityApplicable ability, Entity target) {
        if (!ability.getType().needsDice()) this.attack(stage, ability, target, 0);
        else this.behaviour.chooseDice(dice -> this.attack(stage, ability, target, dice), this.getMaxDice());
    }

    private void attack(Stage stage, EntityApplicable ability, Entity target, int dice) {
        AttackData attack = ability.attack(new AbilityDefensiveAction(this, target, this.focus, dice));
        target.damage(this, attack.getDamage(), ability.getType());
        if (attack.breaksFocus()) target.breakFocus();
        this.useAbility(ability);
        stage.next();
    }

    private void useAbility(EntityApplicable ability) {
        this.addFocus(ability.getFocusChange());
    }

    protected void addFocus(int focus) {
        if (focus > 0) this.game.getEventManager().notify(new EntityFocusGainEvent(this, focus));
        this.focus = Math.max(0, Math.min(this.focus + focus, this.getMaxFocus()));
    }

    protected abstract int getMaxDice();

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
    public void turn(Stage stage, Team[] opponents) {
        this.game.getEventManager().notify(new EntityTurnEvent(this, stage));
        this.behaviour.chooseAbility(ability -> this.turn(stage, opponents, ability),
            this.abilities.toArray(EntityApplicable[]::new));
    }

    @Override
    public void damage(Entity source, int damage, ApplicableType attackType) {
        int effective = damage;
        int reflective = 0;
        if (this.holding != null && this.holding.getType().getAction() == AbilityActionType.DEFENSIVE) {
            OffensiveAction action = new AbilityOffensiveAction(source, this, attackType, damage);
            effective -= this.holding.defend(action);
            reflective = this.holding.reflect(action);
            this.useAbility(this.holding);
        }

        if (effective > 0) this.damage(effective, attackType);
        if (reflective > 0) source.damage(this, reflective, this.holding.getType());
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