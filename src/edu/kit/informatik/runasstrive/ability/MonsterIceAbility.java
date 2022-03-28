package edu.kit.informatik.runasstrive.ability;

/**
 * Represents monster ice ability.
 * Deals 10 * n + 2 damage.
 *
 * @author uvgsj
 * @version v0.1
 */
class MonsterIceAbility extends MonsterMagicOffensiveAbility {

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
        return 10 * this.level + 2;
    }
}