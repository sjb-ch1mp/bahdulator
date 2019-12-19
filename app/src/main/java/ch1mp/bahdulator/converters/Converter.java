package ch1mp.bahdulator.converters;

import ch1mp.bahdulator.InvalidInputException;

/**
 * A Converter must:
 *  1. Check that input for the given data type is valid
 *  2. Implement a conversion method to all other types, and print to the appropriate output.
 *  3. output parameters must be nullable (i.e. if HexConverter, no need to convert to Hex)
 *
 * @author Samuel J. Brookes (sjb-ch1mp)
 */
public abstract class Converter {
    public abstract String inputIsValid(String input) throws InvalidInputException;
    public abstract String convertToHexadecimal();
    public abstract String convertToBinary();
    public abstract String convertToDecimal();
    public abstract String convertToAscii();
}
