package ch1mp.bahdulator.protocols;

import java.util.ArrayList;

public abstract class Protocol {

    private String name;
    private ArrayList<Field> fields;

    public Protocol(String name){
        this.name = name;
        fields = new ArrayList<>(0);
    }

    public void addField(Field field){
        fields.add(field);
    }

    public String getFieldValue(int key){
        for(Field f : fields){
            String value = f.getFieldValue(key);
            if(value != null) return name + " : " + f.getName() + " : " + value;
        }
        return null;
    }

    public String getName(){
        return name;
    }
}
