package ch1mp.bahdulator;

public class NothingFoundException extends Exception {

    private String message;

    public NothingFoundException(String message){
        this.message = message;
    }

    @Override
    public String toString(){
        return message;
    }
}
