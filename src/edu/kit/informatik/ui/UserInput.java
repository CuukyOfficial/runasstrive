package edu.kit.informatik.ui;

import edu.kit.informatik.runasstrive.ability.EntityApplicable;
import edu.kit.informatik.runasstrive.entity.Entity;
import edu.kit.informatik.runasstrive.entity.SkipNoChoiceBehaviour;
import edu.kit.informatik.runasstrive.entity.player.Player;
import edu.kit.informatik.runasstrive.entity.player.PlayerBehaviour;
import edu.kit.informatik.runasstrive.entity.player.RewardType;
import edu.kit.informatik.ui.interaction.DiceRollInteraction;
import edu.kit.informatik.ui.interaction.PickAbilityInteraction;
import edu.kit.informatik.ui.interaction.PickHealCardsInteraction;
import edu.kit.informatik.ui.interaction.PickLootInteraction;
import edu.kit.informatik.ui.interaction.PickRewardTypeChooseInteraction;
import edu.kit.informatik.ui.interaction.PickTargetChooseInteraction;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * This class will respond to every behaviour the game expects
 * the player to respond to with a user input.
 * For that it uses the @{@link edu.kit.informatik.ui.interaction.Interactable}.
 *
 * @author uvgsj
 * @version v0.1
 */
public class UserInput extends SkipNoChoiceBehaviour implements PlayerBehaviour {

    private final Player player;

    /**
     * Create new user input.
     *
     * @param player The player the input will use
     */
    public UserInput(Player player) {
        this.player = player;
    }

    @Override
    public void upgradeDice() {
        this.player.upgradeDice();
    }

    @Override
    public void chooseLoot(Consumer<List<EntityApplicable>> consumer, List<EntityApplicable> loot, int allowed) {
        new PickLootInteraction(consumer, loot.toArray(EntityApplicable[]::new), allowed).interact();
    }

    @Override
    public void chooseSaveAbility(Consumer<EntityApplicable> consumer, EntityApplicable[] options) {
        new PickAbilityInteraction(consumer, options, this.player).interact();
    }

    @Override
    public void chooseSaveEnemy(Consumer<Entity> consumer, List<Entity> enemies) {
        new PickTargetChooseInteraction(consumer, enemies.toArray(Entity[]::new), this.player).interact();
    }

    @Override
    public void chooseSaveHealDiscard(Consumer<List<EntityApplicable>> consumer, List<EntityApplicable> abilities) {
        new PickHealCardsInteraction(consumer, abilities, this.player).interact();
    }

    @Override
    public void chooseDice(Consumer<Integer> dice, int max) {
        new DiceRollInteraction(dice, max).interact();
    }

    @Override
    public void chooseReward(Consumer<List<EntityApplicable>> consumer, List<EntityApplicable> loot, int allowed) {
        RewardType[] canChoose = Arrays.stream(UserRewardType.values()).filter(type ->
            type.canChoose(this.player)).toArray(RewardType[]::new);
        if (canChoose.length == 1)
            canChoose[0].onChoose(this, consumer, loot, allowed);
        else
            new PickRewardTypeChooseInteraction(type -> type.onChoose(this, consumer, loot, allowed),
                UserRewardType.values(), this.player).interact();
    }

    @Override
    public EntityApplicable getNext(EntityApplicable[] options) {
        throw new UnsupportedOperationException("Cannot predict user input!");
    }

    @Override
    public Entity getEntity() {
        return this.player;
    }
}