package edu.kit.informatik.runasstrive.ability;

class MonsterLightningAbility extends MonsterMagicOffensiveAbility {

    MonsterLightningAbility(int level) {
        super(MonsterAbilityType.LIGHTNING, level);
    }

    @Override
    int getDamage(int focus, int dice) {
        return 14 * this.level + 2;
    }
}