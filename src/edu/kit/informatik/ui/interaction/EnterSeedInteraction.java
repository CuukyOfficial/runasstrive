package edu.kit.informatik.ui.interaction;

import edu.kit.informatik.ui.Message;

import java.util.function.Consumer;

public class EnterSeedInteraction extends MultipleNumberInteraction {

    private static final int SEED_AMOUNT = 2;

    public EnterSeedInteraction(Consumer<Integer[]> consumer) {
        super(consumer, 1, Integer.MAX_VALUE, 2, Message.ENTER_SEEDS_ENTER);
    }

    @Override
    protected boolean allowsDuplication() {
        return true;
    }

    @Override
    public void printMessage() {
        System.out.println(Message.ENTER_SEEDS_INFO);
        super.printMessage();
    }

    @Override
    public Integer[] parse(String value) {
        Integer[] seeds = super.parse(value);
        return seeds == null || seeds.length != SEED_AMOUNT ? null : seeds;
    }
}