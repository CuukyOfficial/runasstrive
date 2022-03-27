package edu.kit.informatik.runasstrive.ability;

class RunaWaterAbility extends RunaMagicOffensiveAbility {

    RunaWaterAbility(int level) {
        super(RunaAbilityType.WATER, level);
    }

    @Override
    public int getDamage(int focus, int dice) {
        return (2 * this.level + 4) * focus;
    }
}