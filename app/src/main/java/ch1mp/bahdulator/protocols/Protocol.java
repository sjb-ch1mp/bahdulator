package ch1mp.bahdulator.protocols;

import java.io.File;
import java.util.ArrayList;

public class Protocol {

    private String name;
    private ArrayList<ProtocolField> protocolFields;

    /**
     * @param name - must match the directory name for the protocol
     */
    public Protocol(String name){
        this.name = name;
        importData("data/" + name);
    }

    private void importData(String folderPath){
        protocolFields = new ArrayList<>(0);
        File[] files = new File(folderPath).listFiles();
        if(files != null){
            for(File f : files){
                String name = f.getName();
                name = name.substring(0, name.lastIndexOf("."));
                protocolFields.add(new ProtocolField(name, f.getPath()));
            }
        }
    }

    public FieldValue getFieldValue(int key){
        for(ProtocolField pf : protocolFields){
            FieldValue fieldValue = pf.getFieldValue(key);
            if(fieldValue != null) return fieldValue;
        }
        return null;
    }

    public String getName(){
        return name;
    }
}
