package edu.kit.informatik.ui.interaction;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Describes an interaction that will return a list of the given
 * type which may be empty but never null.
 *
 * @param <T> The type of object this interaction expects to return
 * @author uvgsj
 * @version v0.1
 */
public class MultipleChooseInteraction<T> extends Interaction<List<T>> {

    private final List<T> list;
    private final MultipleNumberInteraction numberInteraction;

    /**
     * Creates new multiple choose interaction.
     *
     * @param consumer The consumer for the chosen elements
     * @param list The list of options
     * @param minAmount The min amount of chosen options
     * @param maxAmount The max amount of chosen otions
     * @param message The message that will be printed
     */
    MultipleChooseInteraction(Consumer<List<T>> consumer, List<T> list, int minAmount, int maxAmount, String message) {
        super(consumer);

        this.list = list;
        this.numberInteraction = new MultipleNumberInteraction(null, 1, list.size(), minAmount, maxAmount);

        System.out.println(message);
        this.printArray(this.list.toArray());
    }

    /**
     * Creates new multiple choose interaction.
     *
     * @param consumer The consumer for the chosen elements
     * @param array The array of options
     * @param minAmount The min amount of chosen options
     * @param maxAmount The max amount of chosen otions
     * @param message The message that will be printed
     */
    MultipleChooseInteraction(Consumer<List<T>> consumer, T[] array, int minAmount, int maxAmount,
                                     String message) {
        this(consumer, Arrays.stream(array).collect(Collectors.toList()), minAmount, maxAmount, message);
    }

    @Override
    public List<T> parse(String value) {
        Integer[] parsed = this.numberInteraction.parse(value);
        if (parsed == null) return null;
        Set<Integer> integers = new LinkedHashSet<>(Arrays.asList(parsed));
        return integers.stream().map(i -> i - 1).map(this.list::get).collect(Collectors.toList());
    }

    @Override
    public void printMessage() {
        this.numberInteraction.printMessage();
    }
}