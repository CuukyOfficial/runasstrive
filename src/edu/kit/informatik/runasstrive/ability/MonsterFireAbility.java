package edu.kit.informatik.runasstrive.ability;

class MonsterFireAbility extends MonsterMagicOffensiveAbility {

    MonsterFireAbility(int level) {
        super(MonsterAbilityType.FIRE, level);
    }

    @Override
    int getDamage(int focus, int dice) {
        return 12 * this.level + 2;
    }
}