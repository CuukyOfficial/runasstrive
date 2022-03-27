package edu.kit.informatik.runasstrive.entity;

import edu.kit.informatik.runasstrive.ability.ApplicableType;
import edu.kit.informatik.runasstrive.ability.EntityApplicable;
import edu.kit.informatik.runasstrive.ability.RunaAbilityType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum RunaType implements EntityType {

    MAGE("Mage", RunaAbilityType.FOCUS, RunaAbilityType.WATER),
    WARRIOR("Warrior", RunaAbilityType.THRUST, RunaAbilityType.PARRY),
    PALADIN("Paladin", RunaAbilityType.SLASH, RunaAbilityType.REFLECT);

    private final String typeName;
    private final ApplicableType[] abilities;

    RunaType(String typeName, ApplicableType... abilities) {
        this.typeName = typeName;
        this.abilities = abilities;
    }

    public String getTypeName() {
        return this.typeName;
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
    public List<EntityApplicable> getAbilities(int level) {
        // Create abilities
        return Arrays.stream(this.abilities).map(a -> a.createAbility(level)).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return this.typeName;
    }

    public static RunaType getType(String typeName) {
        return Arrays.stream(values()).filter(type -> type.getTypeName().equals(typeName))
            .findAny().orElse(null);
    }
}
