package edu.kit.informatik.runasstrive.ability;

/**
 * Represents runa ice ability.
 * Deals (2 * n + 4) * f + 2 damage.
 *
 * @author uvgsj
 * @version v0.1
 */
class RunaIceAbility extends RunaMagicOffensiveAbility {

    private static final int MAGIC_MULTIPLIER = 2;
    private static final int MAGIC_ADD_ONE = 4;
    private static final int MAGIC_ADD_TWO = 2;

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
        return (MAGIC_MULTIPLIER * this.level + MAGIC_ADD_ONE) * focus + MAGIC_ADD_TWO;
    }
}