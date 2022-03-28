package edu.kit.informatik.ui.interaction;

import edu.kit.informatik.runasstrive.ability.EntityApplicable;
import edu.kit.informatik.runasstrive.entity.Entity;
import edu.kit.informatik.ui.Message;

import java.util.function.Consumer;

/**
 * Represents the interaction where the player picks an ability to use.
 *
 * @author uvgsj
 * @version v0.1
 */
public class PickAbilityInteraction extends ChooseInteraction<EntityApplicable> {

    private final Entity entity;

    /**
     * Creates new pick ability interaction.
     *
     * @param consumer The consumer of the chosen ability
     * @param array The array of abilities to be chosen from
     * @param entity The entity that chooses
     */
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