package edu.kit.informatik.ui.interaction;

import java.util.List;
import java.util.function.Consumer;

public class ChooseInteraction<T> extends Interaction<T> {

    private final MultipleChooseInteraction<T> numberInteraction;

    public ChooseInteraction(Consumer<T> consumer, T[] array, String message) {
        super(consumer);

        this.numberInteraction = new MultipleChooseInteraction<>(null, array, 1, message);
    }

    @Override
    public T parse(String value) {
        List<T> chosen = this.numberInteraction.parse(value);
        return chosen == null || chosen.size() != 1 ? null : chosen.get(0);
    }

    @Override
    public void printMessage() {
        this.numberInteraction.printMessage();
    }
}