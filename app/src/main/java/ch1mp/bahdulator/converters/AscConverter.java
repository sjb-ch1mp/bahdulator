package ch1mp.bahdulator.converters;

import ch1mp.bahdulator.InvalidInputException;

/**
 * The AscConverter class takes an ASCII string and converts it into a binary string,
 * a hexadecimal string and a decimal string.
 *
 * @author Samuel J. Brookes (sjb-ch1mp)
 */
public class AscConverter extends Converter {

    private String rawInput;
    private int input;

    public AscConverter(String input) throws InvalidInputException {
        this.input = (int) inputIsValid(input).charAt(0);
        rawInput = input;
    }

    @Override
    public String inputIsValid(String input) throws InvalidInputException{
        if(input.length() > 1 ||
                ((int) input.charAt(0) < 32 || (int) input.charAt(0) > 127))
            throw new InvalidInputException(input + " is not a valid ASCII character");
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
        return "" + input;
    }

    @Override
    public String convertToAscii() {
        return rawInput;
    }
}
