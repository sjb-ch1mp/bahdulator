package ch1mp.bahdulator.converters;

import android.widget.EditText;

import ch1mp.bahdulator.InvalidInputException;
import ch1mp.bahdulator.ascii.AsciiControlChars;

public class HexConverter extends Converter {

    private int input;

    public HexConverter(String input) throws InvalidInputException {
        this.input = Integer.parseInt("0x" + inputIsValid(input));
    }

    @Override
    public String inputIsValid(String input) throws InvalidInputException{
        if(!input.matches("^[0-9a-fA-F]+$"))
            throw new InvalidInputException(input + " is not a valid hexadecimal value");
        return input;
    }

    @Override
    public void convertToHexadecimal(EditText output) {
        //do nothing
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
        if((input >= 0 && input <= 32) || input == 127){
            output.setText(AsciiControlChars.getControlChar(input).getLabel());
        }else if(input >= 33 && input <= 126){
            output.setText((char) input);
        }
    }
}
