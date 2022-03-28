package edu.kit.informatik.runasstrive.ability;

/**
 * Represents the attack data of an offensive ability.
 *
 * @author uvgsj
 * @version v0.1
 */
public class AbilityAttackData implements AttackData {

    private final int damage;
    private final boolean breaksFocus;

    /**
     * Creates new ability attack data.
     *
     * @param damage The damage the attack will deal
     * @param breaksFocus If the attack breaks focus
     */
    public AbilityAttackData(int damage, boolean breaksFocus) {
        this.damage = damage;
        this.breaksFocus = breaksFocus;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public boolean breaksFocus() {
        return this.breaksFocus;
    }
}
