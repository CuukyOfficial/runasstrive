package edu.kit.informatik.runasstrive.ability;

/**
 * Represents scratch ability.
 * Deals 5 * n damage.
 * Breaks focus.
 *
 * @author uvgsj
 * @version v0.1
 */
class ScratchAbility extends OffensiveAbility {

    /**
     * Creates a new ability with the given level.
     *
     * @param level The level
     */
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