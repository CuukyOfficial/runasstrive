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
        return 5 * this.level + dice;
    }
}