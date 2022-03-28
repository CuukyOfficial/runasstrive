package edu.kit.informatik.runasstrive.ability;

/**
 * Represents monster water ability.
 * Deals 8 * n + 2 damage.
 *
 * @author uvgsj
 * @version v0.1
 */
class MonsterWaterAbility extends MonsterMagicOffensiveAbility {

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
        return 8 * this.level + 2;
    }
}