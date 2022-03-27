package edu.kit.informatik.ui.interaction;

import edu.kit.informatik.runasstrive.ability.EntityApplicable;
import edu.kit.informatik.ui.Message;

import java.util.List;
import java.util.function.Consumer;

public class PickLootInteraction extends MultipleChooseInteraction<EntityApplicable> {

    private final int amount;

    public PickLootInteraction(Consumer<List<EntityApplicable>> consumer, EntityApplicable[] array, int amount) {
        super(consumer, array, amount, amount, Message.PICK_LOOT_CARDS.format(amount));

        this.amount = amount;
    }

    @Override
    public List<EntityApplicable> parse(String value) {
        List<EntityApplicable> list = super.parse(value);
        return list == null || list.size() != this.amount ? null : list;
    }
}