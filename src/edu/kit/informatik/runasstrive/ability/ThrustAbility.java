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
        int add = dice >= 6 ? 4 * this.level : 0;
        return 6 * this.level + dice + add;
    }
}