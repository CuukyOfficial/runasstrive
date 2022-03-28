package edu.kit.informatik.runasstrive.ability;

/**
 * Represents monster water ability.
 * Deals 8 * n + 2 damage.
 *
 * @author uvgsj
 * @version v0.1
 */
class MonsterWaterAbility extends MonsterMagicOffensiveAbility {

    private static final int WATER_MULTIPLIER = 8;
    private static final int WATER_ADD = 2;

    /**
     * Creates a new ability with the given level.
     *
     * @param level The level
     */
    MonsterWaterAbility(int level) {
        super(MonsterAbilityType.WATER, level);
    }

    @Override
    int getDamage(int focus, int dice) {
        return WATER_MULTIPLIER * this.level + WATER_ADD;
    }
}