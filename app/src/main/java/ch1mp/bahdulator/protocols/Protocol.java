package ch1mp.bahdulator.protocols;

import java.util.HashMap;

public abstract class Protocol {

    String name;
    HashMap<String, ProtocolField> protocolFields;

    /**
     *
     * @param name - must match the directory name for the protocol
     */
    public Protocol(String name){
        this.name = name;
        importData("dat/" + name);
    }

    private void importData(String folderPath){

    }

    public ProtocolField getProtocolField(String fieldName){
        return protocolFields.get(fieldName);
    }

    public String getName(){
        return name;
    }
}
