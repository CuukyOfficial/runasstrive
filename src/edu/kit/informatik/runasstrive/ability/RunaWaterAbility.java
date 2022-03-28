package edu.kit.informatik.runasstrive.ability;

/**
 * Represents runa water ability.
 * Deals (2 * n + 4) + f damage.
 *
 * @author uvgsj
 * @version v0.1
 */
class RunaWaterAbility extends RunaMagicOffensiveAbility {

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
        return (2 * this.level + 4) * focus;
    }
}