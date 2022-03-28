package edu.kit.informatik.runasstrive.ability;

import edu.kit.informatik.runasstrive.ability.action.AbilityActionType;
import edu.kit.informatik.runasstrive.ability.action.ActionType;
import edu.kit.informatik.runasstrive.entity.EntityElement;
import edu.kit.informatik.runasstrive.entity.LivingEntityElement;

import java.util.function.Function;

/**
 * Contains all the (default) runa abilities.
 *
 * @author uvgsj
 * @version v0.1
 */
public enum RunaAbilityType implements ApplicableType {

    /**
     * The runa ability slash
     */
    SLASH("Slash", AbilityActionType.OFFENSIVE, AbilitySource.PHYSICAL, SlashAbility::new, true),
    /**
     * The runa ability swing
     */
    SWING("Swing", AbilityActionType.OFFENSIVE, AbilitySource.PHYSICAL, SwingAbility::new, true),
    /**
     * The runa ability thrust
     */
    THRUST("Thrust", AbilityActionType.OFFENSIVE, AbilitySource.PHYSICAL, ThrustAbility::new, true),
    /**
     * The runa ability pierce
     */
    PIERCE("Pierce", AbilityActionType.OFFENSIVE, AbilitySource.PHYSICAL, PierceAbility::new, true),
    /**
     * The runa ability parry
     */
    PARRY("Parry", AbilityActionType.DEFENSIVE, AbilitySource.PHYSICAL, ParryAbility::new),
    /**
     * The runa ability focus
     */
    FOCUS("Focus", null, null, RunaFocusAbility::new),
    /**
     * The runa ability reflect
     */
    REFLECT("Reflect", AbilityActionType.DEFENSIVE, AbilitySource.MAGICAL, ReflectAbility::new),
    /**
     * The runa ability water
     */
    WATER("Water", AbilityActionType.OFFENSIVE, AbilitySource.MAGICAL, RunaWaterAbility::new,
        LivingEntityElement.LIGHTNING),
    /**
     * The runa ability ice
     */
    ICE("Ice", AbilityActionType.OFFENSIVE, AbilitySource.MAGICAL, RunaIceAbility::new,
        LivingEntityElement.WATER),
    /**
     * The runa ability fire
     */
    FIRE("Fire", AbilityActionType.OFFENSIVE, AbilitySource.MAGICAL, RunaFireAbility::new,
        LivingEntityElement.ICE),
    /**
     * The runa ability lightning
     */
    LIGHTNING("Lightning", AbilityActionType.OFFENSIVE, AbilitySource.MAGICAL, RunaLightningAbility::new,
        LivingEntityElement.FIRE);

    private final String name;
    private final ActionType action;
    private final ApplicableSource source;
    private final EntityElement[] effective;
    private final boolean dice;
    private final Function<Integer, Ability> abilityCreator;

    RunaAbilityType(String name, ActionType action, ApplicableSource source, Function<Integer,
        Ability> abilityCreator, boolean dice, EntityElement... effective) {
        this.name = name;
        this.action = action;
        this.source = source;
        this.effective = effective;
        this.dice = dice;
        this.abilityCreator = abilityCreator;
    }

    RunaAbilityType(String name, ActionType action, ApplicableSource source, Function<Integer,
        Ability> abilityCreator, EntityElement... effective) {
        this(name, action, source, abilityCreator, false, effective);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public ActionType getAction() {
        return this.action;
    }

    @Override
    public ApplicableSource getSource() {
        return this.source;
    }

    @Override
    public boolean needsDice() {
        return this.dice;
    }

    @Override
    public EntityElement[] getEffective() {
        return this.effective;
    }

    @Override
    public Ability createAbility(int level) {
        return this.abilityCreator.apply(level);
    }
}