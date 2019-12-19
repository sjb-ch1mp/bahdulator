package ch1mp.bahdulator.converters;

import android.widget.EditText;

import ch1mp.bahdulator.InvalidInputException;
import ch1mp.bahdulator.ascii.AsciiControlChars;

public class DecConverter extends Converter {

    private int input;

    public DecConverter(String input) throws InvalidInputException {
        this.input = Integer.parseInt(inputIsValid(input));
    }

    @Override
    public String inputIsValid(String input) throws InvalidInputException{
        if(!input.matches("^[0-9]+$")) throw new InvalidInputException(input + " is not a valid decimal value");
        return input;
    }

    @Override
    public void convertToHexadecimal(EditText output) {
        String hexStr = "0x" + Integer.toHexString(input).toUpperCase();
        output.setText(hexStr);
    }

    @Override
    public void convertToBinary(EditText output) {
        String binStr = Integer.toBinaryString(input);
        while(binStr.length() % 8 != 0){
            binStr = "0" + binStr;
        }
        output.setText(binStr);
    }

    @Override
    public void convertToDecimal(EditText output) {
        //do nothing
    }

    @Override
    public void convertToAscii(EditText output) {
        if((input >= 0 && input <= 32) || input == 127){
            output.setText(AsciiControlChars.getControlChar(input).getLabel());
        }else if(input >= 33 && input <= 126){
            output.setText((char) input);
        }
    }
}
