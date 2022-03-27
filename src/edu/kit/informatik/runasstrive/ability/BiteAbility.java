package edu.kit.informatik.runasstrive.ability;

class BiteAbility extends OffensiveAbility {

    BiteAbility(int level) {
        super(MonsterAbilityType.BITE, level);
    }

    @Override
    int getDamage(int focus, int dice) {
        return 10 * this.level;
    }
}