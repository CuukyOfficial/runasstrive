package edu.kit.informatik.runasstrive.ability;

class MonsterWaterAbility extends MonsterMagicOffensiveAbility {

    MonsterWaterAbility(int level) {
        super(MonsterAbilityType.WATER, level);
    }

    @Override
    int getDamage(int focus, int dice) {
        return 8 * this.level + 2;
    }
}