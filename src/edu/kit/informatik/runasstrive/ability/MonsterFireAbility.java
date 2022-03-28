package edu.kit.informatik.runasstrive.ability;


class MonsterFireAbility extends MonsterMagicOffensiveAbility {

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
        return 12 * this.level + 2;
    }
}