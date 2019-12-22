package ch1mp.bahdulator.converters;

import ch1mp.bahdulator.InvalidInputException;
import ch1mp.bahdulator.ascii.AsciiControlChars;

/**
 * The DecConverter class takes a decimal string and converts it into a binary string,
 * a hexadecimal string and an ASCII string.
 *
 * @author Samuel J. Brookes (sjb-ch1mp)
 */

public class DecConverter extends Converter {

    private String rawInput;
    private int input;

    public DecConverter(String input) throws InvalidInputException {
        this.input = Integer.parseInt(inputIsValid(input));
        rawInput = input;
    }

    @Override
    public String inputIsValid(String input) throws InvalidInputException{
        if(!input.matches("^[0-9]+$")) throw new InvalidInputException(input + " is not a valid decimal value");
        return input;
    }

    @Override
    public String convertToHexadecimal() {
        return "0x" + Integer.toHexString(input).toUpperCase();
    }

    @Override
    public String convertToBinary() {
        String binStr = Integer.toBinaryString(input);
        while(binStr.length() % 8 != 0){
            binStr = "0" + binStr;
        }
        return binStr;
    }

    @Override
    public String convertToDecimal() {
        return rawInput;
    }

    @Override
    public String convertToAscii() {
        if((input >= 0 && input <= 32) || input == 127){
            return AsciiControlChars.getControlChar(input).getLabel();
        }else if(input >= 33 && input <= 126){
            return "" + (char) input;
        }
        return AsciiControlChars.getControlChar(-1).getLabel();
    }
}
