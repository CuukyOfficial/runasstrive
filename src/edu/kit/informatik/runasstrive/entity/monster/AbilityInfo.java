package edu.kit.informatik.runasstrive.entity.monster;

import edu.kit.informatik.runasstrive.ability.ApplicableType;
import edu.kit.informatik.runasstrive.ability.EntityApplicable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents info of abilities.
 * Contains abilities and which levels they are.
 *
 * @author uvgsj
 * @version v0.1
 */
class AbilityInfo {

    private final int stage;
    private final ApplicableType[] abilities;

    /**
     * Creates new ability info.
     *
     * @param stage The level of the abilities
     * @param abilities The abilities
     */
    public AbilityInfo(int stage, ApplicableType... abilities) {
        this.stage = stage;
        this.abilities = abilities;
    }

    /**
     * If this info contains the given ability.
     *
     * @param ability The ability to be checked
     * @return If the info contains the ability
     */
    boolean hasAbility(ApplicableType ability) {
        return Arrays.asList(this.abilities).contains(ability);
    }

    /**
     * Builds all the abilities and their levels.
     *
     * @return The abilities
     */
    List<EntityApplicable> build() {
        return Arrays.stream(this.abilities).map(type -> type.createAbility(this.stage))
            .collect(Collectors.toList());
    }
}