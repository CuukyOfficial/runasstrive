package edu.kit.informatik.runasstrive.ability;

abstract class RunaMagicOffensiveAbility extends OffensiveAbility {

    RunaMagicOffensiveAbility(ApplicableType type, int level) {
        super(type, level);
    }

    @Override
    public int getFocusChange() {
        return -1;
    }

    @Override
    protected int getEffectiveAddition(int focus, int dice) {
        return 2 * this.level;
    }
}