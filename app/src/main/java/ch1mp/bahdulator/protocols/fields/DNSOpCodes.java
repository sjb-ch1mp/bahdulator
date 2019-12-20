package ch1mp.bahdulator.protocols.fields;

import ch1mp.bahdulator.protocols.ProtocolField;
import ch1mp.bahdulator.protocols.Value;

public class DNSOpCodes extends ProtocolField {

    public DNSOpCodes(){

        super("dns.opcodes");

        super.addValue(0, new Value("Query", "Query"));
        super.addValue(1, new Value("IQuery", "Inverse Query (OBSOLETE)"));
        super.addValue(2, new Value("Status", "Status"));
        super.addValue(4, new Value("Notify", "Notify"));
        super.addValue(5, new Value("Update", "Update"));
        super.addValue(6, new Value("DSO", "DNS Stateful Operations"));

    }
}
