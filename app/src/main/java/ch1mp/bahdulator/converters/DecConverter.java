package ch1mp.bahdulator.converters;

import android.widget.EditText;

import ch1mp.bahdulator.InvalidInputException;

public class DecConverter extends Converter {

    public DecConverter(EditText input) throws InvalidInputException {
        super(input);
    }


    @Override
    public void inputIsValid(EditText input) throws InvalidInputException{

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
