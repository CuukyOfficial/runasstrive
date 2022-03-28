package edu.kit.informatik.runasstrive.ability;

/**
 * Represents runa lightning ability.
 * Deals (2 * n + 5) * f + 2 damage.
 *
 * @author uvgsj
 * @version v0.1
 */
public class RunaLightningAbility extends RunaMagicOffensiveAbility {

    /**
     * Creates a new ability with the given level.
     *
     * @param level The level
     */
    RunaLightningAbility(int level) {
        super(RunaAbilityType.LIGHTNING, level);
    }

    @Override
    int getDamage(int focus, int dice) {
        return (2 * this.level + 5) * focus + 2;
    }
}