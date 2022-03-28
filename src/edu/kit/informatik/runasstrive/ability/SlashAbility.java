package edu.kit.informatik.runasstrive.ability;

/**
 * Represents slash ability.
 * Deals 4 * n + w damage.
 * Breaks focus.
 *
 * @author uvgsj
 * @version v0.1
 */
class SlashAbility extends OffensiveAbility {

    /**
     * Creates a new ability with the given level.
     *
     * @param level The level
     */
    SlashAbility(int level) {
        super(RunaAbilityType.SLASH, level);
    }

    @Override
    protected boolean breaksFocus() {
        return true;
    }

    @Override
    public int getDamage(int focus, int dice) {
        return 4 * this.level + dice;
    }
}