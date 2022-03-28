package edu.kit.informatik.ui.interaction;

import edu.kit.informatik.ui.Message;

import java.util.function.Consumer;

/**
 * Represents any number interaction where a number has to be entered.
 *
 * @author uvgsj
 * @version v0.1
 */
public class NumberInteraction extends Interaction<Integer> {

    private final MultipleNumberInteraction numberInteraction;

    /**
     * Creates new number interaction.
     *
     * @param consumer The consumer of the number
     * @param min The min value of the number
     * @param max The max value of the number
     * @param message The message that will be printed
     */
    public NumberInteraction(Consumer<Integer> consumer, int min, int max, Message message) {
        super(consumer);

        this.numberInteraction = new MultipleNumberInteraction(null, min, max, 1, 1, message);
    }

    @Override
    public void printMessage() {
        this.numberInteraction.printMessage();
    }

    @Override
    public Integer parse(String value) {
        Integer[] integers = this.numberInteraction.parse(value);
        return integers == null || integers.length != 1 ? null : integers[0];
    }
}