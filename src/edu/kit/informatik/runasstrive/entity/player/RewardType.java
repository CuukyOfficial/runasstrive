package edu.kit.informatik.runasstrive.entity.player;

import edu.kit.informatik.runasstrive.ability.EntityApplicable;

import java.util.List;
import java.util.function.Consumer;

/**
 * Describes the types of reward the player can choose from when
 * successfully passed the stage.
 *
 * @author uvgsj
 * @version v0.1
 */
public interface RewardType {

    /**
     * Will be called if this type of reward has been chosen.
     *
     * @param behaviour The behaviour of the given player
     * @param choose The abilities the player chooses to get
     * @param options The options the player has
     * @param amount The amount of abilities the player will get
     */
    void onChoose(PlayerBehaviour behaviour, Consumer<List<EntityApplicable>> choose,
                  List<EntityApplicable> options, int amount);

    /**
     * If this reward can be currently chosen by the player.
     *
     * @param player The player that wants to choose this type of reward
     * @return If the reward type can be chosen
     */
    boolean canChoose(Player player);

}