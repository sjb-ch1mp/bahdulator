package ch1mp.bahdulator.protocols;

import java.util.HashMap;

public abstract class ProtocolField {

    private String name;
    private HashMap<Integer, Value> values;

    public ProtocolField(String name){
        this.name = name;
        values = new HashMap<>(0);
    }

    public void addValue(int key, Value value){
        values.put(key, value);
    }

    public Value getFieldValue(int key){
        return values.get(key);
    }

    public String getName(){
        return name;
    }
}
