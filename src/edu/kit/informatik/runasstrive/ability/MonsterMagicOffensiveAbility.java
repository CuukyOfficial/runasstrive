package edu.kit.informatik.runasstrive.ability;

/**
 * Represents any monster magic offensive ability.
 * Reduces focus with -n.
 *
 * @author uvgsj
 * @version v0.1
 */
abstract class MonsterMagicOffensiveAbility extends OffensiveAbility {

    /**
     * Creates a new ability with the given level.
     *
     * @param type The type of ability
     * @param level The level
     */
    MonsterMagicOffensiveAbility(ApplicableType type, int level) {
        super(type, level);
    }

    @Override
    public int getFocusChange() {
        return -this.level;
    }
}