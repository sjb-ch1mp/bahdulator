package ch1mp.bahdulator.protocols.fields;

import ch1mp.bahdulator.protocols.ProtocolField;
import ch1mp.bahdulator.protocols.Value;

/**
 * The container for legal values of the DNS Op Code field.
 *
 * Reference: IANA.org
 *
 * @author Samuel J. Brookes (sjb-ch1mp)
 *
 */
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
