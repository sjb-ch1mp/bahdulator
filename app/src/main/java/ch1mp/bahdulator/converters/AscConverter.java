package ch1mp.bahdulator.converters;

import android.widget.EditText;

import java.util.Formatter;

import ch1mp.bahdulator.InvalidInputException;
import ch1mp.bahdulator.R;

public class AscConverter extends Converter {

    private int input;

    public AscConverter(String input) throws InvalidInputException {
        this.input = (int) inputIsValid(input).charAt(0);

    }

    @Override
    public String inputIsValid(String input) throws InvalidInputException{
        if(input.length() > 1 ||
                ((int) input.charAt(0) < 32 || (int) input.charAt(0) > 127))
            throw new InvalidInputException(input + " is not a valid ASCII character");
        return input;
    }

    @Override
    public void convertToHexadecimal(EditText output) {
        String outStr = "0x" + Integer.toHexString(input);
        output.setText(outStr);
    }

    @Override
    public void convertToBinary(EditText output) {
        output.setText(Integer.toBinaryString(input));
    }

    @Override
    public void convertToDecimal(EditText output) {
        output.setText(input);
    }

    @Override
    public void convertToAscii(EditText output) {
        //do nothing
    }
}
