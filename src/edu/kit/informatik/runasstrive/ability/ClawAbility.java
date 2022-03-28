package edu.kit.informatik.runasstrive.ability;

/**
 * Represents the claw ability.
 * Does 6 * n damage.
 * Breaks focus.
 *
 * @author uvgsj
 * @version v0.1
 */
class ClawAbility extends OffensiveAbility {

    private static final int CLAW_MULTIPLIER = 6;

    /**
     * Creates a new ability with the given level.
     *
     * @param level The level
     */
    ClawAbility(int level) {
        super(MonsterAbilityType.CLAW, level);
    }

    @Override
    boolean breaksFocus() {
        return true;
    }

    @Override
    int getDamage(int focus, int dice) {
        return CLAW_MULTIPLIER * this.level;
    }
}