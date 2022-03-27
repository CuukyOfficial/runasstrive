package edu.kit.informatik.ui.interaction;

import edu.kit.informatik.runasstrive.ability.EntityApplicable;
import edu.kit.informatik.runasstrive.entity.player.Player;
import edu.kit.informatik.ui.Message;

import java.util.List;
import java.util.function.Consumer;

public class PickHealCardsInteraction extends MultipleChooseInteraction<EntityApplicable> {

    public PickHealCardsInteraction(Consumer<List<EntityApplicable>> consumer, List<EntityApplicable> list,
                                    Player player) {
        super(consumer, list, 0, list.size() - 1, Message.PICK_HEAL_CARDS
            .format(player.toString(), player.getHealth(), player.getMaxHealth()));
    }
}