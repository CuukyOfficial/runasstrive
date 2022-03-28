package edu.kit.informatik.ui.interaction;

import edu.kit.informatik.runasstrive.entity.Entity;
import edu.kit.informatik.ui.Message;

import java.util.function.Consumer;

/**
 * Represents an interaction where an entity will choose something.
 *
 * @param <T> Type of object that will be chosen
 * @author uvgsj
 * @version v0.1
 */
public class EntityChooseInteraction<T> extends ChooseInteraction<T> {

    /**
     * Creates new entity choose interaction.
     *
     * @param consumer The consumer of the result
     * @param array The array that will be used to choose an element
     * @param message The message of the interaction
     * @param entity The entity that chooses
     */
    public EntityChooseInteraction(Consumer<T> consumer, T[] array, Message message, Entity entity) {
        super(consumer, array, message.format(entity));
    }
}