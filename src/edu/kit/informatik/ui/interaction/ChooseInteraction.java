package edu.kit.informatik.ui.interaction;

import java.util.List;
import java.util.function.Consumer;

public class ChooseInteraction<T> extends Interaction<T> {

    private final MultipleChooseInteraction<T> interaction;

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