package ch1mp.bahdulator.protocols;

import java.util.HashMap;

/**
 * The ProtocolField class holds all the legal values for a given protocol field, e.g.
 * the value 0x01 = "Destination Unreachable" for the ICMPv6 Type field. Each Protocol Field
 * that is searchable in Bahdulator has an associated ProtocolField class that acts as
 * a container for all it's legal values.
 *
 * @author Samuel J. Brookes (sjb-ch1mp)
 */
public abstract class ProtocolField {

    private String name;
    private HashMap<Integer, Value> values;
    private int min;
    private int max;

    public ProtocolField(String name){
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        this.name = name;
        values = new HashMap<>(0);
    }

    /**
     * Add a value to the values HashMap.
     *
     * @param key - a legal value for the field in base 10
     * @param value - the meaning of the legal value
     */
    public void addValue(int key, Value value){
        if(key < min) min = key;
        if(key > max) max = key;

        values.put(key, value);
    }

    /**
     * Retrieve a value from the values HashMap
     *
     * @param key - the value being searched for in Bahdulator
     * @return - The Value object for this key.
     */
    public Value getFieldValue(int key){
        return values.get(key);
    }

    /**
     * Retrieve the name of this protocol field, e.g. "dns.op_codes"
     *
     * @return - Name of the protocol field
     */
    public String getName(){
        return name;
    }

    public int getMin(){ return min; }
    public int getMax(){ return max; }
}
