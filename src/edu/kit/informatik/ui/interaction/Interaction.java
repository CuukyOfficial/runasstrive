package edu.kit.informatik.ui.interaction;

import edu.kit.informatik.ui.Message;

import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Describes an interaction with the console.
 *
 * @param <T> The type of object this interaction excepts to receive
 * @author uvgsj
 * @version v0.1
 */
public abstract class Interaction<T> implements Interactable<T> {

    private static final String QUIT = "quit";

    private final Consumer<T> consumer;
    private final Scanner scanner;

    /**
     * Creates a new interaction with the console
     * that will trigger the consumer when received a valid input.
     *
     * @param consumer
     */
    Interaction(Consumer<T> consumer) {
        this.consumer = consumer;
        this.scanner = new Scanner(System.in);
    }

    private void respond(T response) {
        if (this.consumer != null)
            this.consumer.accept(response);
    }

    private String awaitResponse() {
        this.printMessage();
        return this.scanner.nextLine();
    }

    /**
     * Prints a given array with into the entry format.
     *
     * @param array The array
     */
    protected void printArray(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Message.CHOOSE_ENTRY.format(i + 1, array[i]));
        }
    }

    @Override
    public void interact() {
        String input = this.awaitResponse();
        if (input.equals(QUIT))
            return;

        T parsed = this.parse(input);
        if (parsed == null) {
            this.interact();
        } else {
            this.respond(parsed);
        }
    }
}