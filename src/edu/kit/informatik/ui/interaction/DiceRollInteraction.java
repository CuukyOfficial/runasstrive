package edu.kit.informatik.ui.interaction;

import edu.kit.informatik.ui.Message;

import java.util.function.Consumer;

/**
 * Represents the dice roll interaction.
 *
 * @author uvgsj
 * @version v0.1
 */
public class DiceRollInteraction extends NumberInteraction {

    /**
     * Creates new dice roll interaction.
     *
     * @param consumer The consumer of the dice result
     * @param max The max dice number
     */
    public DiceRollInteraction(Consumer<Integer> consumer, int max) {
        super(consumer, 1, max, Message.CHOOSE_DICE);
    }
}