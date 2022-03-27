package edu.kit.informatik.runasstrive.ability;

public class RunaLightningAbility extends RunaMagicOffensiveAbility {

    RunaLightningAbility(int level) {
        super(RunaAbilityType.LIGHTNING, level);
    }

    @Override
    int getDamage(int focus, int dice) {
        return (2 * this.level + 5) * focus + 2;
    }
}