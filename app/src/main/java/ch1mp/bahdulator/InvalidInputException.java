package ch1mp.bahdulator;

/**
 * The InvalidInputException is thrown when a user enters an invalid value
 * for a given input field (e.g. placing an 'x' in the binary field)
 *
 * @author Samuel J. Brookes (sjb-ch1mp)
 */
public class InvalidInputException extends Exception {

    private String message;

    public InvalidInputException(String message){
        this.message = message;
    }

    @Override
    public String toString(){
        return message;
    }
}
