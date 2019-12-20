package ch1mp.bahdulator.protocols;

public class Value {

    private String id;
    private String description;

    public Value(String id, String description){
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
