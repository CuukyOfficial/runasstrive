package edu.kit.informatik.runasstrive.ability;

/**
 * Represents smash ability.
 * Deals 8 * n damage.
 *
 * @author uvgsj
 * @version v0.1
 */
class SmashAbility extends OffensiveAbility {

    /**
     * Creates a new ability with the given level.
     *
     * @param level The level
     */
    SmashAbility(int level) {
        super(MonsterAbilityType.SMASH, level);
    }

    @Override
    int getDamage(int focus, int dice) {
        return 8 * this.level;
    }
}