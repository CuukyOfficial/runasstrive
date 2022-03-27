package edu.kit.informatik.runasstrive.ability;

class SwingAbility extends OffensiveAbility {

    SwingAbility(int level) {
        super(RunaAbilityType.SWING, level);
    }

    @Override
    protected boolean breaksFocus() {
        return true;
    }

    @Override
    protected int getDamage(int focus, int dice) {
        return 5 * this.level + dice;
    }
}