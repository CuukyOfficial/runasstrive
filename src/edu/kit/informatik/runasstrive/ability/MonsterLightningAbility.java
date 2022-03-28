package edu.kit.informatik.runasstrive.ability;

/**
 * Represents monster lightning ability.
 * Deals 14 * n + 2 damage.
 *
 * @author uvgsj
 * @version v0.1
 */
class MonsterLightningAbility extends MonsterMagicOffensiveAbility {

    private static final int LIGHTNING_MULTIPLIER = 14;
    private static final int LIGHTNING_ADD = 2;

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
        return LIGHTNING_MULTIPLIER * this.level + LIGHTNING_ADD;
    }
}