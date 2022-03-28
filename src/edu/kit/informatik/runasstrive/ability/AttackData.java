package edu.kit.informatik.runasstrive.ability;

/**
 * Contains various information of an incoming attack.
 *
 * @author uvgsj
 * @version v0.1
 */
public interface AttackData {

    /**
     * Returns the damage the attack will deal.
     *
     * @return The damage
     */
    int getDamage();

    /**
     * Returns whether the attack breaks focus or not.
     *
     * @return If the attack breaks focus
     */
    boolean breaksFocus();

}