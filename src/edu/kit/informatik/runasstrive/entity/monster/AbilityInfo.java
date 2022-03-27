package edu.kit.informatik.runasstrive.entity.monster;

import edu.kit.informatik.runasstrive.ability.ApplicableType;
import edu.kit.informatik.runasstrive.ability.EntityApplicable;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class AbilityInfo extends AbstractMap.SimpleEntry<Integer, ApplicableType[]> {

    public AbilityInfo(Integer key, ApplicableType... value) {
        super(key, value);
    }

    boolean hasAbility(ApplicableType ability) {
        return Arrays.asList(this.getValue()).contains(ability);
    }

    List<EntityApplicable> build() {
        return Arrays.stream(this.getValue()).map(type -> type.createAbility(this.getKey()))
            .collect(Collectors.toList());
    }
}