package ch1mp.bahdulator.converters;

import ch1mp.bahdulator.InvalidInputException;

/**
 * A Converter must:
 *  1. Check that input for the given data type is valid
 *  2. Implement a conversion method to all other types, and print to the appropriate output.
 *
 * @author Samuel J. Brookes (sjb-ch1mp)
 */
public abstract class Converter {

    /**
     * Checks that the input is valid for the give data type (e.g. decimal, binary, etc)
     *
     * @param input - An ASCII, binary, decimal or hexadecimal string
     * @return - input (if no exception is thrown)
     * @throws InvalidInputException - if the input is invalid for the given data type.
     */
    public abstract String inputIsValid(String input) throws InvalidInputException;

    /**
     * Converts this Converters input string into a hexadecimal string.
     *
     * @return - A hexadecimal string
     */
    public abstract String convertToHexadecimal();

    /**
     * Converts this Converters input string into a binary string.
     *
     * @return - A binary string
     */
    public abstract String convertToBinary();

    /**
     * Converts this Converters input string into a decimal string.
     *
     * @return - A decimal string
     */
    public abstract String convertToDecimal();

    /**
     * Converts this Converters input string into an ASCII string.
     *
     * @return - An ASCII string
     */
    public abstract String convertToAscii();
}
