package edu.kit.informatik.runasstrive;

import java.util.function.Consumer;

/**
 * Represents anything that can provide the game needed seeds
 * to shuffle the cards.
 *
 * @author uvgsj
 * @version v0.1
 */
@FunctionalInterface
public interface SeedProvider {

    /**
     * Requests the seeds.
     *
     * @param consumer The consumer of the seeds
     */
    void requestSeeds(Consumer<Integer[]> consumer);

}