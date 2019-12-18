package ch1mp.bahdulator.converters;

import android.widget.EditText;

import ch1mp.bahdulator.InvalidInputException;

/**
 * A Converter must:
 *  1. Contain a reference to the EditText from which it gets its input.
 *  2. Implement a conversion method to all other types, and print to the appropriate output.
 *  3. output parameters must be nullable (i.e. if HexConverter, no need to convert to Hex)
 *
 * @author Samuel J. Brookes (sjb-ch1mp)
 */
public abstract class Converter {

    private EditText input;

    public Converter(EditText input) throws InvalidInputException {
        inputIsValid(input);
        this.input = input;
    }

    public abstract void inputIsValid(EditText input) throws InvalidInputException;
    public abstract void convertToHexadecimal(EditText output);
    public abstract void convertToBinary(EditText output);
    public abstract void convertToDecimal(EditText output);
    public abstract void convertToAscii(EditText output);
}
