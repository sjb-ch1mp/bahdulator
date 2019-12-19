package ch1mp.bahdulator.converters;

import android.widget.EditText;

import ch1mp.bahdulator.InvalidInputException;

public class DecConverter extends Converter {

    private String input;

    public DecConverter(String input) throws InvalidInputException {
        inputIsValid(input);
    }

    @Override
    public String inputIsValid(String input) throws InvalidInputException{
        return input;
    }

    @Override
    public void convertToHexadecimal(EditText output) {

    }

    @Override
    public void convertToBinary(EditText output) {

    }

    @Override
    public void convertToDecimal(EditText output) {
        //do nothing
    }

    @Override
    public void convertToAscii(EditText output) {

    }
}
