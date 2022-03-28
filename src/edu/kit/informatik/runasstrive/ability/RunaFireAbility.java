package edu.kit.informatik.runasstrive.ability;

/**
 * Represents fire ability.
 * Deals (2 * n + 5) * f damage.
 *
 * @author uvgsj
 * @version v0.1
 */
class RunaFireAbility extends RunaMagicOffensiveAbility {

    /**
     * Creates a new ability with the given level.
     *
     * @param level The level
     */
    RunaFireAbility(int level) {
        super(RunaAbilityType.FIRE, level);
    }

    @Override
    protected int getDamage(int focus, int dice) {
        return (2 * this.level + 5) * focus;
    }
}
