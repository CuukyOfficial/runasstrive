package edu.kit.informatik.runasstrive.ability;

/**
 * Represents fire ability.
 * Deals (2 * n + 5) * f damage.
 *
 * @author uvgsj
 * @version v0.1
 */
class RunaFireAbility extends RunaMagicOffensiveAbility {

    private static final int FIRE_MULTIPLIER = 2;
    private static final int FIRE_ADD = 5;

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
        return (FIRE_MULTIPLIER * this.level + FIRE_ADD) * focus;
    }
}
