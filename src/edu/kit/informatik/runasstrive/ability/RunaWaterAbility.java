package edu.kit.informatik.runasstrive.ability;

/**
 * Represents runa water ability.
 * Deals (2 * n + 4) + f damage.
 *
 * @author uvgsj
 * @version v0.1
 */
class RunaWaterAbility extends RunaMagicOffensiveAbility {

    private static final int WATER_MULTIPLIER = 2;
    private static final int WATER_ADD = 4;

    /**
     * Creates a new ability with the given level.
     *
     * @param level The level
     */
    RunaWaterAbility(int level) {
        super(RunaAbilityType.WATER, level);
    }

    @Override
    public int getDamage(int focus, int dice) {
        return (WATER_MULTIPLIER * this.level + WATER_ADD) * focus;
    }
}