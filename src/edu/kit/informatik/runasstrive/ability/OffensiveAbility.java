package edu.kit.informatik.runasstrive.ability;

import edu.kit.informatik.runasstrive.ability.action.OffensiveSourceActionInfo;
import edu.kit.informatik.runasstrive.entity.Entity;

import java.util.Arrays;

/**
 * Represents any offensive ability.
 * Can be effective to some element types.
 * Can break focus of enemy.
 *
 * @author uvgsj
 * @version v0.1
 */
abstract class OffensiveAbility extends Ability {

    /**
     * Creates new offensive ability.
     *
     * @param type The type of the ability
     * @param level The level of the ability
     */
    OffensiveAbility(ApplicableType type, int level) {
        super(type, level);
    }

    private boolean isEffectiveAgainst(Entity entity) {
        return Arrays.asList(this.type.getEffective()).contains(entity.getType().getElement());
    }

    /**
     * Returns how much damage the ability deals.
     *
     * @param focus The amount of focus points
     * @param dice The dice number
     * @return The amount of damage
     */
    abstract int getDamage(int focus, int dice);

    /**
     * Returns how much an effective attack would deal extra.
     *
     * @param focus The amount of focus points
     * @param dice The dice number
     * @return The amount of damage
     */
    int getEffectiveAddition(int focus, int dice) {
        return 0;
    }

    /**
     * Returns if the focus of the enemy will be broken.
     *
     * @return If the focus will be broken
     */
    boolean breaksFocus() {
        return false;
    }

    @Override
    public final AttackData attack(OffensiveSourceActionInfo action) {
        int damage = this.getDamage(action.getFocusPoints(), action.getDice());
        if (this.isEffectiveAgainst(action.getTarget()))
            damage += this.getEffectiveAddition(action.getFocusPoints(), action.getDice());
        return new AbilityAttackData(damage, this.breaksFocus());
    }
}