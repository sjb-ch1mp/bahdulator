package ch1mp.bahdulator.protocols;

import java.util.HashMap;

public abstract class Field {

    private String name;
    private HashMap<Integer, String> values;

    public Field(String name){
        this.name = name;
        values = new HashMap<>(0);
    }

    public void addValue(int value, String name){
        values.put(value, name);
    }

    String getFieldValue(int key){
        return values.get(key);
    }

    public String getName(){
        return name;
    }
}
