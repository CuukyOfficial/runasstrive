package edu.kit.informatik.ui.interaction;

import edu.kit.informatik.runasstrive.ability.EntityApplicable;
import edu.kit.informatik.runasstrive.entity.Entity;
import edu.kit.informatik.ui.Message;

import java.util.function.Consumer;

public class PickAbilityInteraction extends ChooseInteraction<EntityApplicable> {

    private final Entity entity;

    public PickAbilityInteraction(Consumer<EntityApplicable> consumer, EntityApplicable[] array, Entity entity) {
        super(consumer, array, Message.PICK_PLAY_CARD.toString());

        this.entity = entity;
    }

    @Override
    public EntityApplicable parse(String value) {
        EntityApplicable applicable = super.parse(value);
        return applicable == null || !this.entity.canPerform(applicable) ? null : applicable;
    }
}