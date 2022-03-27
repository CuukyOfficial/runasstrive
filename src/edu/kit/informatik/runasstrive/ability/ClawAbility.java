package edu.kit.informatik.runasstrive.ability;

class ClawAbility extends OffensiveAbility {

    ClawAbility(int level) {
        super(MonsterAbilityType.CLAW, level);
    }

    @Override
    boolean breaksFocus() {
        return true;
    }

    @Override
    int getDamage(int focus, int dice) {
        return 6 * this.level;
    }
}