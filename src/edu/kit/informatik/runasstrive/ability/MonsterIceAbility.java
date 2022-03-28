package edu.kit.informatik.runasstrive.ability;

/**
 * Represents monster ice ability.
 * Deals 10 * n + 2 damage.
 *
 * @author uvgsj
 * @version v0.1
 */
class MonsterIceAbility extends MonsterMagicOffensiveAbility {

    private static final int ICE_MULTIPLIER = 10;
    private static final int ICE_ADD = 2;

    /**
     * Creates a new ability with the given level.
     *
     * @param level The level
     */
    MonsterIceAbility(int level) {
        super(MonsterAbilityType.ICE, level);
    }

    @Override
    int getDamage(int focus, int dice) {
        return ICE_MULTIPLIER * this.level + ICE_ADD;
    }
}