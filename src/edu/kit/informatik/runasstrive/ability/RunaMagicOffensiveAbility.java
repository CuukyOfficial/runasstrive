package edu.kit.informatik.runasstrive.ability;

/**
 * Represents any runa magic offensive ability.
 * It will decrease the focus with 1.
 * Effective attacks will deal 2 * n extra.
 *
 * @author uvgsj
 * @version v0.1
 */
abstract class RunaMagicOffensiveAbility extends OffensiveAbility {

    /**
     * Creates a new ability with the given level.
     *
     * @param type The type of the ability
     * @param level The level
     */
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