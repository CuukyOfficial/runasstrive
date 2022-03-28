package edu.kit.informatik.ui.interaction;

import java.util.List;
import java.util.function.Consumer;

/**
 * Represents any interaction that chooses on element of an array.
 *
 * @param <T> The type of element this will choose
 * @author uvgsj
 * @version v0.1
 */
public class ChooseInteraction<T> extends Interaction<T> {

    private final MultipleChooseInteraction<T> interaction;

    /**
     * Creates new choose interaction.
     *
     * @param consumer The consumer of the chosen element
     * @param array The array to choose from
     * @param message The message to be printed
     */
    public ChooseInteraction(Consumer<T> consumer, T[] array, String message) {
        super(consumer);

        this.interaction = new MultipleChooseInteraction<>(null, array, 1, 1, message);
    }

    @Override
    public T parse(String value) {
        List<T> chosen = this.interaction.parse(value);
        return chosen == null ? null : chosen.get(0);
    }

    @Override
    public void printMessage() {
        this.interaction.printMessage();
    }
}