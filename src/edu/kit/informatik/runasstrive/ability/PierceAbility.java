package edu.kit.informatik.runasstrive.ability;

/**
 * Represents pierce ability.
 * Deals 7 * n + w damage.
 * Additionally, if w >= 6 it will deal an extra 5 * n
 *
 * @author uvgsj
 * @version v0.1
 */
class PierceAbility extends OffensiveAbility {

    private static final int PIERCE_MULTIPLIER = 7;
    private static final int PIERCE_ADD_LIMIT = 6;
    private static final int PIERCE_ADD_MULTIPLIER = 5;

    /**
     * Creates a new ability with the given level.
     *
     * @param level The level
     */
    PierceAbility(int level) {
        super(RunaAbilityType.PIERCE, level);
    }

    @Override
    protected int getDamage(int focus, int dice) {
        int add = dice >= PIERCE_ADD_LIMIT ? PIERCE_ADD_MULTIPLIER * this.level : 0;
        return PIERCE_MULTIPLIER * this.level + dice + add;
    }
}