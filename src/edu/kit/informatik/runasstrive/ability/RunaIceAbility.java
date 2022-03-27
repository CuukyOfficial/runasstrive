package edu.kit.informatik.runasstrive.ability;

class RunaIceAbility extends RunaMagicOffensiveAbility {

    RunaIceAbility(int level) {
        super(RunaAbilityType.ICE, level);
    }

    @Override
    protected int getDamage(int focus, int dice) {
        return (2 * this.level + 4) * focus + 2;
    }
}