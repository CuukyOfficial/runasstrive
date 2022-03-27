package edu.kit.informatik.ui.interaction;

import edu.kit.informatik.ui.Message;

import java.util.function.Consumer;

public class DiceRollInteraction extends NumberInteraction {

    public DiceRollInteraction(Consumer<Integer> consumer, int max) {
        super(consumer, 1, max, Message.CHOOSE_DICE);
    }
}