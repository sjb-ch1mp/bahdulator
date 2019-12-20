package ch1mp.bahdulator.protocols;

import java.util.HashMap;

public abstract class ProtocolField {

    String name;
    HashMap<Integer, FieldValue> fieldValues;

    public ProtocolField(String name, String filePath){
        this.name = name;
        importData(filePath);
    }

    abstract HashMap<Integer, FieldValue> importData(String filePath);

    public FieldValue getFieldValue(int key){
        return fieldValues.get(key);
    }

    public String getName(){
        return name;
    }
}
