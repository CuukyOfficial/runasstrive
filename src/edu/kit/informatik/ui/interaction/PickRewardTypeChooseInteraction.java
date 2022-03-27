package edu.kit.informatik.ui.interaction;

import edu.kit.informatik.runasstrive.entity.Entity;
import edu.kit.informatik.ui.Message;
import edu.kit.informatik.runasstrive.entity.player.RewardType;

import java.util.function.Consumer;

public class PickRewardTypeChooseInteraction extends EntityChooseInteraction<RewardType> {

    public PickRewardTypeChooseInteraction(Consumer<RewardType> consumer, RewardType[] array, Entity entity) {
        super(consumer, array, Message.PICK_REWARD_TYPE, entity);
    }
}