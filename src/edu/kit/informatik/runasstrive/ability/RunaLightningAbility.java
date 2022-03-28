package edu.kit.informatik.runasstrive.ability;

/**
 * Represents runa lightning ability.
 * Deals (2 * n + 5) * f + 2 damage.
 *
 * @author uvgsj
 * @version v0.1
 */
public class RunaLightningAbility extends RunaMagicOffensiveAbility {

    private static final int LIGHTNING_MULTIPLIER = 2;
    private static final int LIGHTNING_ADD_ONE = 5;
    private static final int LIGHTNING_ADD_TWO = 2;

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
        return (LIGHTNING_MULTIPLIER * this.level + LIGHTNING_ADD_ONE) * focus + LIGHTNING_ADD_TWO;
    }
}