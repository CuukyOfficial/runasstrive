package edu.kit.informatik.runasstrive.ability;

/**
 * Represents the bite monster ability.
 * Does 10 * n damage.
 *
 * @author uvgsj
 * @version v0.1
 */
class BiteAbility extends OffensiveAbility {

    private static final int BITE_MULTIPLIER = 10;

    /**
     * Creates a new ability with the given level.
     *
     * @param level The level
     */
    BiteAbility(int level) {
        super(MonsterAbilityType.BITE, level);
    }

    @Override
    int getDamage(int focus, int dice) {
        return BITE_MULTIPLIER * this.level;
    }
}