package edu.kit.informatik.ui.interaction;

/**
 * Describes an object that can parse something.
 *
 * @param <T> The object this can parse
 * @author uvgsj
 * @version v0.1
 */
public interface InputParser<T> {

    /**
     * Parses the given input.
     *
     * @param value The value to be parsed
     * @return The parsed value
     */
    T parse(String value);

}