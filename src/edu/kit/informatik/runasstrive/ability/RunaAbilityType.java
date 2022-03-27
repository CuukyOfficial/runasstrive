package edu.kit.informatik.runasstrive.ability;

import edu.kit.informatik.runasstrive.ability.action.AbilityActionType;
import edu.kit.informatik.runasstrive.ability.action.ActionType;
import edu.kit.informatik.runasstrive.entity.EntityElement;
import edu.kit.informatik.runasstrive.entity.LivingEntityElement;

import java.util.function.Function;

public enum RunaAbilityType implements ApplicableType {

    SLASH("Slash", AbilityActionType.OFFENSIVE, AbilitySource.PHYSICAL, SlashAbility::new, true),
    SWING("Swing", AbilityActionType.OFFENSIVE, AbilitySource.PHYSICAL, SwingAbility::new, true),
    THRUST("Thrust", AbilityActionType.OFFENSIVE, AbilitySource.PHYSICAL, ThrustAbility::new, true),
    PIERCE("Pierce", AbilityActionType.OFFENSIVE, AbilitySource.PHYSICAL, PierceAbility::new, true),
    PARRY("Parry", AbilityActionType.DEFENSIVE, AbilitySource.PHYSICAL, ParryAbility::new),
    FOCUS("Focus", null, null, FocusAbility::new),
    REFLECT("Reflect", AbilityActionType.DEFENSIVE, AbilitySource.MAGICAL, ReflectAbility::new),
    WATER("Water", AbilityActionType.OFFENSIVE, AbilitySource.MAGICAL, RunaWaterAbility::new,
        LivingEntityElement.LIGHTNING),
    ICE("Ice", AbilityActionType.OFFENSIVE, AbilitySource.MAGICAL, RunaIceAbility::new,
        LivingEntityElement.WATER),
    FIRE("Fire", AbilityActionType.OFFENSIVE, AbilitySource.MAGICAL, RunaFireAbility::new,
        LivingEntityElement.ICE),
    LIGHTNING("Lightning", AbilityActionType.OFFENSIVE, AbilitySource.MAGICAL, RunaLightningAbility::new,
        LivingEntityElement.LIGHTNING);

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