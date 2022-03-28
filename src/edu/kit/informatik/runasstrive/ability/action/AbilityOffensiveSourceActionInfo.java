package edu.kit.informatik.runasstrive.ability.action;

import edu.kit.informatik.runasstrive.entity.Entity;

/**
 * Represents any ability defensive action.
 * For more see @{@link OffensiveSourceActionInfo}.
 *
 * @author uvgsj
 * @version v0.1
 */
public class AbilityOffensiveSourceActionInfo extends AbilityActionInfo implements OffensiveSourceActionInfo {

    private final int focusPoints;
    private final int dice;

    /**
     * Creates new ability defensive action.
     *
     * @param source The source
     * @param target The target
     * @param focusPoints The focus points
     * @param dice The dice
     */
    public AbilityOffensiveSourceActionInfo(Entity source, Entity target, int focusPoints, int dice) {
        super(source, target);

        this.focusPoints = focusPoints;
        this.dice = dice;
    }

    @Override
    public int getFocusPoints() {
        return this.focusPoints;
    }

    @Override
    public int getDice() {
        return this.dice;
    }
}