package edu.kit.informatik.ui.interaction;

import edu.kit.informatik.runasstrive.entity.Entity;
import edu.kit.informatik.ui.Message;

import java.util.function.Consumer;

public class EntityChooseInteraction<T> extends ChooseInteraction<T> {

    public EntityChooseInteraction(Consumer<T> consumer, T[] array, Message message, Entity entity) {
        super(consumer, array, message.format(entity));
    }
}