package edu.kit.informatik.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Copies a given list and iterates over it.
 * Removing an entity from the given list will result in
 * skipping it in the iteration.
 *
 * @param <T> The type of the list
 * @author uvgsj
 * @version v0.1
 */
public class SaveIterator<T> {

    private final List<T> iterate;
    private final Predicate<T> skip;
    private int index;

    /**
     * Creates a new iterator with the given list.
     *
     * @param iterator The list to be iterated over
     */
    public SaveIterator(List<T> iterator) {
        this.iterate = new ArrayList<>(iterator);
        this.skip = list -> !iterator.contains(list);
    }

    /**
     * If the iterator now has iterated over every entry.
     *
     * @return If the iterator has finished
     */
    public boolean isFinished() {
        return this.index >= this.iterate.size();
    }

    /**
     * Returns the next element while not changing the iteration.
     *
     * @return The next element
     */
    public T previewNext() {
        return this.isFinished() ? this.iterate.get(0) : this.iterate.get(this.index);
    }

    /**
     * Returns the next element of the iteration.
     *
     * @return The element of the iteration
     */
    public T next() {
        if (this.isFinished()) this.index = 0;
        T chosen = this.iterate.get(this.index);
        this.index++;
        return this.skip.test(chosen) ? this.next() : chosen;
    }

    /**
     * If the list this iterator iterates over and the given one are equal.
     *
     * @param list The list to be compared with
     * @return If the lists are equal
     */
    public boolean isEqual(List<T> list) {
        return this.iterate.equals(list);
    }
}