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
        int add = dice >= 6 ? 5 * this.level : 0;
        return 7 * this.level + dice + add;
    }
}