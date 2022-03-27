package edu.kit.informatik.runasstrive.ability;

class ThrustAbility extends OffensiveAbility {

    ThrustAbility(int level) {
        super(RunaAbilityType.THRUST, level);
    }

    @Override
    protected int getDamage(int focus, int dice) {
        int add = dice >= 6 ? 4 * this.level : 0;
        return 6 * this.level + dice + add;
    }
}