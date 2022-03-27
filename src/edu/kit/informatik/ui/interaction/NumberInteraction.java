package edu.kit.informatik.ui.interaction;

import edu.kit.informatik.ui.Message;

import java.util.function.Consumer;

public class NumberInteraction extends Interaction<Integer> {

    private final MultipleNumberInteraction numberInteraction;

    public NumberInteraction(Consumer<Integer> consumer, int min, int max, Message message) {
        super(consumer);

        this.numberInteraction = new MultipleNumberInteraction(null, min, max, 1, message);
    }

    public NumberInteraction(Consumer<Integer> consumer, int min, int max) {
        this(consumer, min, max, Message.ENTER_NUMBER);
    }

    public NumberInteraction(int max) {
        this(null, 1, max);
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