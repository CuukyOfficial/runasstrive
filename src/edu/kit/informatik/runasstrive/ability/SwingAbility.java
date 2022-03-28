package edu.kit.informatik.runasstrive.ability;

/**
 * Represents swing ability.
 * Deals 5 * n + w damage.
 * Breaks focus.
 *
 * @author uvgsj
 * @version v0.1
 */
class SwingAbility extends OffensiveAbility {

    private static final int SWING_MULTIPLIER = 5;

    /**
     * Creates a new ability with the given level.
     *
     * @param level The level
     */
    SwingAbility(int level) {
        super(RunaAbilityType.SWING, level);
    }

    @Override
    protected boolean breaksFocus() {
        return true;
    }

    @Override
    protected int getDamage(int focus, int dice) {
        return SWING_MULTIPLIER * this.level + dice;
    }
}