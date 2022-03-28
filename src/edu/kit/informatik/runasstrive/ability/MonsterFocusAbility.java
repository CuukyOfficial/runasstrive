package edu.kit.informatik.runasstrive.ability;

/**
 * Represents monster focus ability.
 * Gains 1 focus.
 *
 * @author uvgsj
 * @version v0.1
 */
public class MonsterFocusAbility extends Ability {

    /**
     * Creates a new ability with the given level.
     *
     * @param level The level
     */
    MonsterFocusAbility(int level) {
        super(MonsterAbilityType.FOCUS, level);
    }

    @Override
    public int getFocusChange() {
        return 1;
    }
}