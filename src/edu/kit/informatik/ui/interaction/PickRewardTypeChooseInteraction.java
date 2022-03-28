package edu.kit.informatik.ui.interaction;

import edu.kit.informatik.runasstrive.entity.Entity;
import edu.kit.informatik.ui.Message;
import edu.kit.informatik.runasstrive.entity.player.RewardType;

import java.util.function.Consumer;

/**
 * Represents the pick reward type interaction.
 *
 * @author uvgsj
 * @version v0.1
 */
public class PickRewardTypeChooseInteraction extends EntityChooseInteraction<RewardType> {

    /**
     * Creates new pick reward type interaction.
     *
     * @param consumer The consumer that consumes the chosen reward type
     * @param array The array of reward type to be chosen from
     * @param entity The entity that chooses
     */
    public PickRewardTypeChooseInteraction(Consumer<RewardType> consumer, RewardType[] array, Entity entity) {
        super(consumer, array, Message.PICK_REWARD_TYPE, entity);
    }
}