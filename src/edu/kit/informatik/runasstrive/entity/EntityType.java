package edu.kit.informatik.runasstrive.entity;

import edu.kit.informatik.runasstrive.ability.ApplicableType;
import edu.kit.informatik.runasstrive.ability.EntityApplicable;

import java.util.List;

public interface EntityType {

    String getName();

    int getMaxHealth();

    int getStartFocus();

    EntityElement getElement();

    boolean hasDefaultAbility(ApplicableType type);

    List<EntityApplicable> getAbilities(int level);

}