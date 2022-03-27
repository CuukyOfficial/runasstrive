package edu.kit.informatik.runasstrive.ability;

class SlashAbility extends OffensiveAbility {

    SlashAbility(int level) {
        super(RunaAbilityType.SLASH, level);
    }

    @Override
    protected boolean breaksFocus() {
        return true;
    }

    @Override
    public int getDamage(int focus, int dice) {
        return 4 * this.level + dice;
    }
}