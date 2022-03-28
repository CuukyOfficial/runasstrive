package edu.kit.informatik.runasstrive.entity;

import edu.kit.informatik.runasstrive.ability.ApplicableType;
import edu.kit.informatik.runasstrive.ability.EntityApplicable;
import edu.kit.informatik.runasstrive.ability.RunaAbilityType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents all types of entity Runa can be.
 *
 * @author uvgsj
 * @version v0.1
 */
public enum RunaType implements EntityType {

    /**
     * Warrior type with default abilities thrust and parry.
     */
    WARRIOR("Warrior", RunaAbilityType.THRUST, RunaAbilityType.PARRY),
    /**
     * Mage type with default abilities focus and water
     */
    MAGE("Mage", RunaAbilityType.FOCUS, RunaAbilityType.WATER),
    /**
     * Paladin type with default abilities focus and water
     */
    PALADIN("Paladin", RunaAbilityType.SLASH, RunaAbilityType.REFLECT);

    private final String typeName;
    private final ApplicableType[] abilities;

    /**
     * Creates new Runa type.
     *
     * @param typeName The name of the type
     * @param abilities The default abilities
     */
    RunaType(String typeName, ApplicableType... abilities) {
        this.typeName = typeName;
        this.abilities = abilities;
    }

    @Override
    public String getName() {
        return "Runa";
    }

    @Override
    public int getMaxHealth() {
        return 50;
    }

    @Override
    public int getStartFocus() {
        return 1;
    }

    @Override
    public EntityElement getElement() {
        return null;
    }

    @Override
    public boolean hasDefaultAbility(ApplicableType type) {
        return Arrays.asList(this.abilities).contains(type);
    }

    @Override
    public List<EntityApplicable> getAbilities(int stage) {
        // Create abilities
        return Arrays.stream(this.abilities).map(a -> a.createAbility(stage)).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return this.typeName;
    }

    public static RunaType getType(String typeName) {
        // Filter types and returns matching one
        return Arrays.stream(values()).filter(type -> type.typeName.equals(typeName))
            .findAny().orElse(null);
    }
}
