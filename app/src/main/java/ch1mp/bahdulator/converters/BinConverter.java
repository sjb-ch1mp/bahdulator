package ch1mp.bahdulator.converters;

import ch1mp.bahdulator.InvalidInputException;
import ch1mp.bahdulator.ascii.AsciiControlChars;

public class BinConverter extends Converter {

    private String rawInput;
    private int input;

    public BinConverter(String input) throws InvalidInputException {
        this.input = Integer.parseInt(inputIsValid(input), 2);
        rawInput = input;
    }

    @Override
    public String inputIsValid(String input) throws InvalidInputException{
        if(!input.matches("^[01]+$")) throw new InvalidInputException(input + " is not a valid binary value");
        return input;
    }

    @Override
    public String convertToHexadecimal() {
        return "0x" + Integer.toHexString(input).toUpperCase();
    }

    @Override
    public String convertToBinary() {
        String binStr = rawInput;
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
