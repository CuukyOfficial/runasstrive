package edu.kit.informatik.runasstrive.ability;

/**
 * Represents runa focus ability.
 * Adds n focus.
 *
 * @author uvgsj
 * @version v0.1
 */
class RunaFocusAbility extends Ability {

    /**
     * Creates a new ability with the given level.
     *
     * @param level The level
     */
    RunaFocusAbility(int level) {
        super(RunaAbilityType.FOCUS, level);
    }

    @Override
    public int getFocusChange() {
        return this.level;
    }
}