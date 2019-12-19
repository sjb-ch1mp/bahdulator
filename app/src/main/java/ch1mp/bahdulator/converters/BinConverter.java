package ch1mp.bahdulator.converters;

import android.widget.EditText;

import ch1mp.bahdulator.InvalidInputException;
import ch1mp.bahdulator.ascii.AsciiControlChars;

public class BinConverter extends Converter {

    private int input;

    public BinConverter(String input) throws InvalidInputException {
        this.input = toInt(inputIsValid(input));
    }

    private int toInt(String input){
        int inputAsInt = 0;
        int pow = 0;
        for(int i=input.length() - 1; i>=0; i--){
            inputAsInt += Integer.parseInt(input.substring(i, i+1)) * Math.pow(2, pow++);
        }
        return inputAsInt;
    }

    @Override
    public String inputIsValid(String input) throws InvalidInputException{
        if(!input.matches("^[01]+$")) throw new InvalidInputException(input + " is not a valid binary value");
        return input;
    }

    @Override
    public void convertToHexadecimal(EditText output) {
        String hexStr = "0x" + Integer.toHexString(input);
        output.setText(hexStr);
    }

    @Override
    public void convertToBinary(EditText output) {
        //do nothing
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
