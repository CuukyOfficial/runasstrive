package edu.kit.informatik.ui.interaction;

import edu.kit.informatik.runasstrive.ability.EntityApplicable;
import edu.kit.informatik.runasstrive.entity.player.Player;
import edu.kit.informatik.ui.Message;

import java.util.List;
import java.util.function.Consumer;

/**
 * Represents the pick cards for heal interaction.
 *
 * @author uvgsj
 * @version v0.1
 */
public class PickHealCardsInteraction extends MultipleChooseInteraction<EntityApplicable> {

    /**
     * Creates new pick heal cards interaction.
     *
     * @param consumer The consumer that accepts the cards that will be traded
     * @param list The list of abilities to choose from
     * @param player The player that chooses
     */
    public PickHealCardsInteraction(Consumer<List<EntityApplicable>> consumer, List<EntityApplicable> list,
                                    Player player) {
        super(consumer, list, 0, list.size() - 1, Message.PICK_HEAL_CARDS
            .format(player.toString(), player.getHealth(), player.getMaxHealth()));
    }
}