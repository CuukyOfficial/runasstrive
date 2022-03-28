package edu.kit.informatik.ui.interaction;

import edu.kit.informatik.ui.Message;

import java.util.function.Consumer;

/**
 * Represents the 'enter seeds' interaction.
 *
 * @author uvgsj
 * @version v0.1
 */
public class EnterSeedInteraction extends MultipleNumberInteraction {

    private static final int SEED_AMOUNT = 2;

    /**
     * Creates a new 'enter seeds' interaction.
     *
     * @param consumer The consumer for the seeds
     */
    public EnterSeedInteraction(Consumer<Integer[]> consumer) {
        super(consumer, 1, Integer.MAX_VALUE, 2, 2, Message.ENTER_SEEDS_ENTER);

        System.out.println(Message.ENTER_SEEDS_INFO);
    }

    @Override
    protected boolean allowsDuplication() {
        return true;
    }

    @Override
    public Integer[] parse(String value) {
        Integer[] seeds = super.parse(value);
        return seeds == null || seeds.length != SEED_AMOUNT ? null : seeds;
    }
}