package ch1mp.bahdulator.converters;

import ch1mp.bahdulator.InvalidInputException;
import ch1mp.bahdulator.ascii.AsciiControlChars;

/**
 * The HexConverter class takes a hexadecimal string and converts it into a binary string,
 * a decimal string and an ASCII string.
 *
 * @author Samuel J. Brookes (sjb-ch1mp)
 */
public class HexConverter extends Converter {

    private String rawInput;
    private long input;

    public HexConverter(String input) throws InvalidInputException {
        if(input.matches("^0x")) input = input.substring(2);
        this.input = Long.parseLong(inputIsValid(input), 16);
        rawInput = input;
    }

    @Override
    public String inputIsValid(String input) throws InvalidInputException{
        if(!input.matches("^[0-9a-fA-F]+$"))
            throw new InvalidInputException(input + " is not a valid hexadecimal value");
        return input;
    }

    @Override
    public String convertToHexadecimal() {
        return "0x" + rawInput;
    }

    @Override
    public String convertToBinary() {
        String binStr = Long.toBinaryString(input);
        while(binStr.length() % 8 != 0){
            binStr = "0" + binStr;
        }
        return binStr;
    }

    @Override
    public String convertToDecimal() {
        return "" + input;
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
