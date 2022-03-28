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
    private final int maxAmount;
    private final Message message;

    /**
     * Creates new multiple number interaction.
     *
     * @param consumer The consumer of the numbers
     * @param min The min value of any number
     * @param max The max value of any number
     * @param minAmount The min amount of numbers
     * @param maxAmount The max amount of numbers
     * @param message The message that will be printed
     */
    public MultipleNumberInteraction(Consumer<Integer[]> consumer, int min, int max, int minAmount,
                                     int maxAmount, Message message) {
        super(consumer);

        this.min = min;
        this.max = max;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.message = message;
    }

    /**
     * Creates new multiple number interaction.
     * Will choose messages based on max amount of numbers.
     *
     * @param consumer The consumer of the numbers
     * @param min The min value of any number
     * @param max The max value of any number
     * @param minAmount The min amount of numbers
     * @param maxAmount The max amount of numbers
     */
    public MultipleNumberInteraction(Consumer<Integer[]> consumer, int min, int max, int minAmount, int maxAmount) {
        this(consumer, min, max, minAmount, maxAmount, maxAmount <= 1 ? Message.ENTER_NUMBER : Message.ENTER_NUMBERS);
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
        String[] valueSplit = value.split(SEPARATOR);
        if (!value.matches(ALLOWED)) return null;
        Collection<Integer> numbers = new ArrayList<>();
        if (!value.isEmpty()) {
            for (String numberString : valueSplit) {
                Integer number = this.parseNumber(numberString);
                if (number == null || !this.allowsDuplication() && numbers.contains(number)) return null;
                numbers.add(number);
            }
        }

        return numbers.size() < this.minAmount || numbers.size() > this.maxAmount
            ? null : numbers.toArray(Integer[]::new);
    }
}