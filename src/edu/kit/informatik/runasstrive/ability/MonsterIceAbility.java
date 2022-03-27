package edu.kit.informatik.runasstrive.ability;

class MonsterIceAbility extends MonsterMagicOffensiveAbility {

    MonsterIceAbility(int level) {
        super(MonsterAbilityType.ICE, level);
    }

    @Override
    int getDamage(int focus, int dice) {
        return 10 * this.level + 2;
    }
}