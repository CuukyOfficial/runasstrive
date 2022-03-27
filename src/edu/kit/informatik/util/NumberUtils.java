package edu.kit.informatik.util;

/**
 * Used to calculate numbers.
 *
 * @author uvgsj
 * @version v0.1
 */
public final class NumberUtils {

    private NumberUtils() {
    }

    /**
     * Calculates the next number, if exceeded maximum, it will start at 0.
     *
     * @param current The current number
     * @param max The maximum number
     * @return The calculated Number
     */
    public static int getNext(int current, int max) {
        return current + 1 >= max ? 0 : current + 1;
    }
}