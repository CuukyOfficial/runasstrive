package edu.kit.informatik.runasstrive.ability;

import edu.kit.informatik.runasstrive.ability.action.AbilityActionType;
import edu.kit.informatik.runasstrive.ability.action.ActionType;
import edu.kit.informatik.runasstrive.entity.EntityElement;

import java.util.function.Function;

public enum MonsterAbilityType implements ApplicableType {

    SCRATCH("Scratch", AbilityActionType.OFFENSIVE, AbilitySource.PHYSICAL, ScratchAbility::new),
    CLAW("Claw", AbilityActionType.OFFENSIVE, AbilitySource.PHYSICAL, ClawAbility::new),
    SMASH("Smash", AbilityActionType.OFFENSIVE, AbilitySource.PHYSICAL, SmashAbility::new),
    BITE("Bite", AbilityActionType.OFFENSIVE, AbilitySource.PHYSICAL, BiteAbility::new),
    // TODO: MonsterFocus
    FOCUS("Focus", null, null, FocusAbility::new),
    BLOCK("Block", AbilityActionType.DEFENSIVE, AbilitySource.PHYSICAL, BlockAbility::new),
    DEFLECT("Deflect", AbilityActionType.DEFENSIVE, AbilitySource.MAGICAL, DeflectAbility::new),
    WATER("Water", AbilityActionType.OFFENSIVE, AbilitySource.MAGICAL, MonsterWaterAbility::new),
    ICE("Ice", AbilityActionType.OFFENSIVE, AbilitySource.MAGICAL, MonsterIceAbility::new),
    FIRE("Fire", AbilityActionType.OFFENSIVE, AbilitySource.MAGICAL, MonsterFireAbility::new),
    LIGHTNING("Lightning", AbilityActionType.OFFENSIVE, AbilitySource.MAGICAL, MonsterLightningAbility::new);

    private final String name;
    private final ActionType action;
    private final ApplicableSource source;
    private final Function<Integer, Ability> abilityCreator;

    MonsterAbilityType(String name, ActionType action, ApplicableSource source,
                       Function<Integer, Ability> abilityCreator) {
        this.name = name;
        this.action = action;
        this.source = source;
        this.abilityCreator = abilityCreator;
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
        return false;
    }

    @Override
    public EntityElement[] getEffective() {
        return new EntityElement[0];
    }

    @Override
    public Ability createAbility(int level) {
        return this.abilityCreator.apply(level);
    }
}