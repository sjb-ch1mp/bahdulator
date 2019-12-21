package ch1mp.bahdulator.protocols.fields;

import ch1mp.bahdulator.protocols.ProtocolField;
import ch1mp.bahdulator.protocols.Value;

/**
 * The container for legal values of the Ethernet Ethertype field.
 *
 * Reference: IANA.org
 *
 * @author Samuel J. Brookes (sjb-ch1mp)
 *
 */
public class EtherTypes extends ProtocolField {

    public EtherTypes(){
        super("eth.types");

        super.addValue(2048, new Value("Ipv4", "Internet Protocol version 4"));
        super.addValue(2054, new Value("ARP", "Address Resolution Protocol"));
        super.addValue(32821, new Value("RARP", "Reverse Address Resolution Protocol"));
        super.addValue(34525, new Value("Ipv6", "Internet Protocol version 6"));
        super.addValue(34827, new Value("PPP", "Point-to-Point Protocol"));
    }
}
