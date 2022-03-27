package edu.kit.informatik.runasstrive.ability;

class FocusAbility extends Ability {

    FocusAbility(int level) {
        super(RunaAbilityType.FOCUS, level);
    }

    @Override
    public int getFocusChange() {
        return this.level;
    }
}