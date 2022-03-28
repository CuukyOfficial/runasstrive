package edu.kit.informatik.runasstrive.ability;

import edu.kit.informatik.runasstrive.ability.action.AbilityActionType;
import edu.kit.informatik.runasstrive.ability.action.ActionType;
import edu.kit.informatik.runasstrive.entity.EntityElement;

import java.util.function.Function;

/**
 * Contains all the (default) monster abilities.
 *
 * @author uvgsj
 * @version v0.1
 */
public enum MonsterAbilityType implements ApplicableType {

    /**
     * The scratch ability
     */
    SCRATCH("Scratch", AbilityActionType.OFFENSIVE, AbilitySource.PHYSICAL, ScratchAbility::new),
    /**
     * The claw ability
     */
    CLAW("Claw", AbilityActionType.OFFENSIVE, AbilitySource.PHYSICAL, ClawAbility::new),
    /**
     * The smash ability
     */
    SMASH("Smash", AbilityActionType.OFFENSIVE, AbilitySource.PHYSICAL, SmashAbility::new),
    /**
     * The bite ability
     */
    BITE("Bite", AbilityActionType.OFFENSIVE, AbilitySource.PHYSICAL, BiteAbility::new),
    /**
     * The monster focus ability
     */
    FOCUS("Focus", null, null, MonsterFocusAbility::new),
    /**
     * The block ability
     */
    BLOCK("Block", AbilityActionType.DEFENSIVE, AbilitySource.PHYSICAL, BlockAbility::new),
    /**
     * The 'deflect' ability
     */
    DEFLECT("Deflect", AbilityActionType.DEFENSIVE, AbilitySource.MAGICAL, DeflectAbility::new),
    /**
     * The monster water ability
     */
    WATER("Water", AbilityActionType.OFFENSIVE, AbilitySource.MAGICAL, MonsterWaterAbility::new),
    /**
     * The monster ice ability
     */
    ICE("Ice", AbilityActionType.OFFENSIVE, AbilitySource.MAGICAL, MonsterIceAbility::new),
    /**
     * The monster ice ability
     */
    FIRE("Fire", AbilityActionType.OFFENSIVE, AbilitySource.MAGICAL, MonsterFireAbility::new),
    /**
     * The monster lightning ability
     */
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