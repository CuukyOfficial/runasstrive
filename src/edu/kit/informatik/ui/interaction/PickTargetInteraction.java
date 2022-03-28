package edu.kit.informatik.ui.interaction;

import edu.kit.informatik.runasstrive.entity.Entity;
import edu.kit.informatik.ui.Message;

import java.util.function.Consumer;

/**
 * Represents the pick ability target interaction.
 *
 * @author uvgsj
 * @version v0.1
 */
public class PickTargetInteraction extends EntityChooseInteraction<Entity> {

    /**
     * Creates new pick target interaction.
     *
     * @param consumer The consumer of the picked target
     * @param array The targets to be chosen from
     * @param entity The entity that chooses
     */
    public PickTargetInteraction(Consumer<Entity> consumer, Entity[] array, Entity entity) {
        super(consumer, array, Message.CHOOSE_TARGET, entity);
    }
}