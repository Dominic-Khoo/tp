package seedu.address.model.person;

import seedu.address.logic.commands.TriageCommand;
import seedu.address.logic.parser.exceptions.ParseException;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

/**
 * Represents the triage level of a person in the system.
 * A Triage object stores a triage value indicating the stage of illness.
 * Valid triage values are integers between 1 and 5, where 1 indicates Stable and 5 indicates Bereaved.
 */
public class Triage {

    /** The triage value indicating the stage of illness. */
    public String value;

    /** The message constraint for valid triage values. */
    public static final String MESSAGE_CONSTRAINTS =
            "Valid triaging stages are from numbers 1 to 5, with 1 indicating Stable and 5 indicating Bereaved.";

    /**
     * Constructs a Triage object with the given triage value.
     *
     * @param triage The triage level as a string, representing the stage of illness.
     * @throws NullPointerException if the triage value is null.
     */
    public Triage(String triage) {
        requireNonNull(triage);
        this.value = triage;
    }

    /**
     * Checks if the triage value is empty (null).
     *
     * @return true if the triage value is null, false otherwise.
     */
    public boolean isEmpty() {
        return value == null;
    }

    /**
     * Validates the given triage value.
     * The triage value must be an integer between 1 and 5 (inclusive),
     * where 1 indicates Stable and 5 indicates Bereaved.
     *
     * @param num The string to validate.
     * @return true if the triage value is valid (1-5), false otherwise.
     * @throws ParseException if the input is not a valid integer or not within the valid range.
     */
    public static boolean isValidTriage(String num) throws ParseException {
        int test = -1;
        // Try parsing the string into an integer
        try {
            test = Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, TriageCommand.MESSAGE_USAGE), e);
        }
        return test > 0 && test < 6; // Valid triage range is from 1 to 5
    }

    /**
     * Returns the string representation of the triage value.
     *
     * @return the string representing the triage value.
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }

    /**
     * Checks if two Triage objects are equal.
     *
     * @param other The object to compare with.
     * @return true if the other object is a Triage and has the same triage value.
     */
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Triage // instanceof handles nulls
                && value == (((Triage) other).value)); // state check
    }

    /**
     * Returns the hash code of the Triage object.
     *
     * @return the hash code of the triage value.
     */
    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
