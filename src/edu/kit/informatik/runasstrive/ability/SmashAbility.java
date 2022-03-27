package edu.kit.informatik.runasstrive.ability;

class SmashAbility extends OffensiveAbility {

    SmashAbility(int level) {
        super(MonsterAbilityType.SMASH, level);
    }

    @Override
    int getDamage(int focus, int dice) {
        return 8 * this.level;
    }
}