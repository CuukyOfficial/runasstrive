package edu.kit.informatik.runasstrive.ability;

/**
 * Represents thrust ability.
 * Deals 6 * n + w damage.
 * Additionally, if w >= 6 it will deal 4 * n damage extra.
 *
 * @author uvgsj
 * @version v0.1
 */
class ThrustAbility extends OffensiveAbility {

    private static final int THRUST_MULTIPLIER = 6;
    private static final int THRUST_ADD_LIMIT = 6;
    private static final int THRUST_ADD_AMOUNT = 4;

    /**
     * Creates a new ability with the given level.
     *
     * @param level The level
     */
    ThrustAbility(int level) {
        super(RunaAbilityType.THRUST, level);
    }

    @Override
    protected int getDamage(int focus, int dice) {
        int add = dice >= THRUST_ADD_LIMIT ? THRUST_ADD_AMOUNT * this.level : 0;
        return THRUST_MULTIPLIER * this.level + dice + add;
    }
}