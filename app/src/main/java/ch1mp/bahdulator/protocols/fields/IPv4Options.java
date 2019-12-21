package ch1mp.bahdulator.protocols.fields;

import ch1mp.bahdulator.protocols.ProtocolField;
import ch1mp.bahdulator.protocols.Value;

/**
 * The container for legal values of the IPv4 Options field.
 *
 * Reference: IANA.org
 *
 * @author Samuel J. Brookes (sjb-ch1mp)
 *
 */
public class IPv4Options extends ProtocolField {

    public IPv4Options(){
        super("ipv4.options");

        super.addValue(0, new Value("EOOL", "End of Options List"));
        super.addValue(1, new Value("NOP", "No Operation"));
        super.addValue(130, new Value("SEC", "Security"));
        super.addValue(131, new Value("LSR", "Loose Source Route"));
        super.addValue(68, new Value("TS", "Time Stamp"));
        super.addValue(133, new Value("E-SEC", "Extended Security"));
        super.addValue(134, new Value("CIPSO", "Commercial Security"));
        super.addValue(7, new Value("RR", "Record Route"));
        super.addValue(136, new Value("SID", "Stream ID"));
        super.addValue(137, new Value("SSR", "Strict Source Route"));
        super.addValue(10, new Value("ZSU", "Experimental Measurement"));
        super.addValue(11, new Value("MTUP", "MTU Probe"));
        super.addValue(12, new Value("MTUR", "MTU Reply"));
        super.addValue(205, new Value("FINN", "Experimental Flow Control"));
        super.addValue(142, new Value("VISA", "Experimental Access Control"));
        super.addValue(15, new Value("ENCODE", "???"));
        super.addValue(144, new Value("IMITD", "IMI Traffic Descriptor"));
        super.addValue(145, new Value("EIP", "Extended Internet Protocol"));
        super.addValue(82, new Value("TR", "Traceroute"));
        super.addValue(147, new Value("ADDEXT", "Address Extension"));
        super.addValue(148, new Value("RTRALT", "Router Alert"));
        super.addValue(149, new Value("SDB", "Selective Directed Broadcast"));
        super.addValue(151, new Value("DPS", "Dynamic Packet State"));
        super.addValue(152, new Value("UMP", "Upstream Multicast Pkt."));
        super.addValue(25, new Value("QS", "Quick-Start"));
        super.addValue(30, new Value("EXP", "RFC3692-style Experiment [2]"));
        super.addValue(94, new Value("EXP", "RFC3692-style Experiment [2]"));
        super.addValue(158, new Value("EXP", "RFC3692-style Experiment [2]"));
        super.addValue(222, new Value("EXP", "RFC3692-style Experiment [2]"));
    }
}
