package edu.kit.informatik.ui.interaction;

import edu.kit.informatik.ui.Message;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

/**
 * Describes an interaction that expects a given amount of
 * numbers between a given interval.
 *
 * @author uvgsj
 * @version v0.1
 */
class MultipleNumberInteraction extends Interaction<Integer[]> {

    /**
     * Allow any number followed by any number separated with a ','
     */
    private static final String ALLOWED = "(\\d+)*(,\\d+)*";
    private static final String SEPARATOR = ",";

    private final int min;
    private final int max;
    private final int minAmount;
    private final Message message;

    public MultipleNumberInteraction(Consumer<Integer[]> consumer, int min, int max, int minAmount, Message message) {
        super(consumer);

        this.min = min;
        this.max = max;
        this.message = message;
        this.minAmount = minAmount;
    }

    public MultipleNumberInteraction(Consumer<Integer[]> consumer, int min, int max, int minAmount) {
        this(consumer, min, max, minAmount, minAmount == 1 ? Message.ENTER_NUMBER : Message.ENTER_NUMBERS);
    }

    private Integer parseNumber(String value) {
        int number;
        try {
            number = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return null;
        }

        if (number < this.min || number > this.max)
            return null;

        return number;
    }

    /**
     * Returns if the interaction allows duplication in the input.
     *
     * @return If this interaction allows duplication
     */
    protected boolean allowsDuplication() {
        return false;
    }

    @Override
    public void printMessage() {
        System.out.println(this.message.format(this.min, this.max));
    }

    @Override
    public Integer[] parse(String value) {
        if (value.isEmpty()) return new Integer[0];
        String[] valueSplit = value.split(SEPARATOR);
        if (!value.matches(ALLOWED)) return null;
        Collection<Integer> numbers = new ArrayList<>();
        for (String numberString : valueSplit) {
            Integer number = this.parseNumber(numberString);
            if (number == null || !this.allowsDuplication() && numbers.contains(number)) return null;
            numbers.add(number);
        }

        return numbers.size() < this.minAmount ? null : numbers.toArray(Integer[]::new);
    }
}