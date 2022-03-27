package edu.kit.informatik.runasstrive.ability;

abstract class MonsterMagicOffensiveAbility extends OffensiveAbility {

    MonsterMagicOffensiveAbility(ApplicableType type, int level) {
        super(type, level);
    }

    @Override
    public int getFocusChange() {
        return -this.level;
    }
}