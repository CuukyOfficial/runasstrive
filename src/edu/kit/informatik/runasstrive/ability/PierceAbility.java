package edu.kit.informatik.runasstrive.ability;

class PierceAbility extends OffensiveAbility {

    PierceAbility(int level) {
        super(RunaAbilityType.PIERCE, level);
    }

    @Override
    protected int getDamage(int focus, int dice) {
        int add = dice >= 6 ? 5 * this.level : 0;
        return 7 * this.level + dice + add;
    }
}