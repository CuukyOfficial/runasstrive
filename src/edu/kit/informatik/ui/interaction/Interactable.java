package edu.kit.informatik.ui.interaction;

/**
 * Describes something that can interact with the console and
 * handles its inputs.
 *
 * @param <T> The type of thing this can parse
 * @author uvgsj
 * @version v0.1
 */
public interface Interactable<T> extends InputParser<T> {

    /**
     * Prints the message of the interaction.
     */
    void printMessage();

    /**
     * Prints the message and waits for the console to respond.
     */
    void interact();

}