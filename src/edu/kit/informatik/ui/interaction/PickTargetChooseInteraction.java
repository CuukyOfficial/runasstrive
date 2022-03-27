package edu.kit.informatik.ui.interaction;

import edu.kit.informatik.runasstrive.entity.Entity;
import edu.kit.informatik.ui.Message;

import java.util.function.Consumer;

public class PickTargetChooseInteraction extends EntityChooseInteraction<Entity> {

    public PickTargetChooseInteraction(Consumer<Entity> consumer, Entity[] array, Entity entity) {
        super(consumer, array, Message.CHOOSE_TARGET, entity);
    }
}