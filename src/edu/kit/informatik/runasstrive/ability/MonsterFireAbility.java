package edu.kit.informatik.runasstrive.ability;


class MonsterFireAbility extends MonsterMagicOffensiveAbility {

    private static final int FIRE_MULTIPLIER = 12;
    private static final int FIRE_ADD = 2;

    /**
     * Creates a new ability with the given level.
     *
     * @param level The level
     */
    MonsterFireAbility(int level) {
        super(MonsterAbilityType.FIRE, level);
    }

    @Override
    int getDamage(int focus, int dice) {
        return FIRE_MULTIPLIER * this.level + FIRE_ADD;
    }
}