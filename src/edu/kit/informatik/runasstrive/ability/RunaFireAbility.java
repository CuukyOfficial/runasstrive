package edu.kit.informatik.runasstrive.ability;

class RunaFireAbility extends RunaMagicOffensiveAbility {

    RunaFireAbility(int level) {
        super(RunaAbilityType.FIRE, level);
    }

    @Override
    protected int getDamage(int focus, int dice) {
        return (2 * this.level + 5) * focus;
    }
}
