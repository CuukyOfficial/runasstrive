package edu.kit.informatik.runasstrive.ability;

/**
 * Represents monster lightning ability.
 * Deals 14 * n + 2 damage.
 *
 * @author uvgsj
 * @version v0.1
 */
class MonsterLightningAbility extends MonsterMagicOffensiveAbility {

    /**
     * Creates a new ability with the given level.
     *
     * @param level The level
     */
    MonsterLightningAbility(int level) {
        super(MonsterAbilityType.LIGHTNING, level);
    }

    @Override
    int getDamage(int focus, int dice) {
        return 14 * this.level + 2;
    }
}