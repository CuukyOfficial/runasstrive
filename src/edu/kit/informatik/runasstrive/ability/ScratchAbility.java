package edu.kit.informatik.runasstrive.ability;

class ScratchAbility extends OffensiveAbility {

    ScratchAbility(int level) {
        super(MonsterAbilityType.SCRATCH, level);
    }

    @Override
    boolean breaksFocus() {
        return true;
    }

    @Override
    int getDamage(int focus, int dice) {
        return 5 * this.level;
    }
}