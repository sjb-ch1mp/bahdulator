package ch1mp.bahdulator.protocols;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class ProtocolField {

    private String name;
    private HashMap<Integer, FieldValue> fieldValues;

    ProtocolField(String name, String filePath){
        this.name = name;
        importData(filePath);
    }

    private void importData(String filePath) {
        fieldValues = new HashMap<>(0);
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line = br.readLine(); //skip the first line
            while((line = br.readLine()) != null){
                String[] fieldData = line.split(",");
                int key = Integer.parseInt(fieldData[0]);
                fieldValues.put(key, new FieldValue(key, fieldData[1], fieldData[2]));
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public FieldValue getFieldValue(int key){
        return fieldValues.get(key);
    }

    public String getName(){
        return name;
    }
}
