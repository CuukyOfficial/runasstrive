package edu.kit.informatik.runasstrive.entity.player;

import edu.kit.informatik.runasstrive.Game;
import edu.kit.informatik.runasstrive.ability.ApplicableType;
import edu.kit.informatik.runasstrive.ability.EntityApplicable;
import edu.kit.informatik.runasstrive.entity.Behaviour;
import edu.kit.informatik.runasstrive.entity.EntityType;
import edu.kit.informatik.runasstrive.entity.LivingEntity;
import edu.kit.informatik.runasstrive.event.entity.PlayerDiceUpgradeEvent;
import edu.kit.informatik.ui.UserInput;

/**
 * Represents the entity player.
 * It contains a die, and it cannot have less focus points
 * than one. Also, if the player dice the attack that
 * killed it will not be reflected.
 *
 * @author uvgsj
 * @version v0.1
 */
public class EntityPlayer extends LivingEntity implements Player {

    private Dice dice;

    /**
     * Creates a new player.
     *
     * @param game The game of the player
     * @param entityType The type of the player
     */
    public EntityPlayer(Game game, EntityType entityType) {
        super(game, entityType);

        this.dice = PlayerDice.D4;
    }

    @Override
    protected Behaviour createBehaviour() {
        return new UserInput(this);
    }

    @Override
    protected void addFocus(int focus) {
        super.addFocus(focus < 0 && this.getFocus() + focus < 1 ? -(this.getFocus() - 1) : focus);
    }

    @Override
    protected boolean damage(int damage, ApplicableType attackType) {
        return super.damage(damage, attackType) && this.getHealth() > 0;
    }

    @Override
    public int getMaxFocus() {
        return this.dice.getMaxValue();
    }

    @Override
    protected int getMaxDice() {
        return this.dice.getMaxValue();
    }

    @Override
    public void upgradeDice() {
        Dice upgrade = this.dice.getUpgrade();
        this.getGame().getEventManager().notify(new PlayerDiceUpgradeEvent(this, upgrade));
        this.dice = upgrade;
    }

    @Override
    public boolean canPerform(EntityApplicable ability) {
        return true;
    }

    @Override
    public boolean canUpgradeDice() {
        return this.dice.getUpgrade() != null;
    }
}