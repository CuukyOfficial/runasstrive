package edu.kit.informatik.runasstrive.ability;

/**
 * Represents runa ice ability.
 * Deals (2 * n + 4) * f + 2 damage.
 *
 * @author uvgsj
 * @version v0.1
 */
class RunaIceAbility extends RunaMagicOffensiveAbility {

    /**
     * Creates a new ability with the given level.
     *
     * @param level The level
     */
    RunaIceAbility(int level) {
        super(RunaAbilityType.ICE, level);
    }

    @Override
    protected int getDamage(int focus, int dice) {
        return (2 * this.level + 4) * focus + 2;
    }
}