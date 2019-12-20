package ch1mp.bahdulator.protocols.fields;

import ch1mp.bahdulator.protocols.ProtocolField;
import ch1mp.bahdulator.protocols.Value;

public class ICMPTypes extends ProtocolField {

    public ICMPTypes(){
        super("icmp.types");

        super.addValue(0, new Value("Echo Reply", "Echo Reply"));
        super.addValue(3, new Value("Destination Unreachable", "Destination Unreachable"));
        super.addValue(4, new Value("Source Quench (Deprecated)", "Source Quench (Deprecated)"));
        super.addValue(5, new Value("Redirect", "Redirect"));
        super.addValue(6, new Value("Alternate Host Address (Deprecated)", "Alternate Host Address (Deprecated)"));
        super.addValue(7, new Value("Unassigned", "Unassigned"));
        super.addValue(8, new Value("Echo", "Echo"));
        super.addValue(9, new Value("Router Advertisement", "Router Advertisement"));
        super.addValue(10, new Value("Router Solicitation", "Router Solicitation"));
        super.addValue(11, new Value("Time Exceeded", "Time Exceeded"));
        super.addValue(12, new Value("Parameter Problem", "Parameter Problem"));
        super.addValue(13, new Value("Timestamp", "Timestamp"));
        super.addValue(14, new Value("Timestamp Reply", "Timestamp Reply"));
        super.addValue(15, new Value("Information Request (Deprecated)", "Information Request (Deprecated)"));
        super.addValue(16, new Value("Information Reply (Deprecated)", "Information Reply (Deprecated)"));
        super.addValue(17, new Value("Address Mask Request (Deprecated)", "Address Mask Request (Deprecated)"));
        super.addValue(18, new Value("Address Mask Reply (Deprecated)", "Address Mask Reply (Deprecated)"));
        super.addValue(30, new Value("Traceroute (Deprecated)", "Traceroute (Deprecated)"));
        super.addValue(31, new Value("Datagram Conversion Error (Deprecated)", "Datagram Conversion Error (Deprecated)"));
        super.addValue(32, new Value("Mobile Host Redirect (Deprecated)", "Mobile Host Redirect (Deprecated)"));
        super.addValue(33, new Value("IPv6 Where-Are-You (Deprecated)", "IPv6 Where-Are-You (Deprecated)"));
        super.addValue(34, new Value("IPv6 I-Am-Here (Deprecated)", "IPv6 I-Am-Here (Deprecated)"));
        super.addValue(35, new Value("Mobile Registration Request (Deprecated)", "Mobile Registration Request (Deprecated)"));
        super.addValue(36, new Value("Mobile Registration Reply (Deprecated)", "Mobile Registration Reply (Deprecated)"));
        super.addValue(37, new Value("Domain Name Request (Deprecated)", "Domain Name Request (Deprecated)"));
        super.addValue(38, new Value("Domain Name Reply (Deprecated)", "Domain Name Reply (Deprecated)"));
        super.addValue(39, new Value("SKIP (Deprecated)", "SKIP (Deprecated)"));
        super.addValue(40, new Value("Photuris", "Photuris"));
        super.addValue(42, new Value("Extended Echo Request", "Extended Echo Request"));
        super.addValue(43, new Value("Extended Echo Reply", "Extended Echo Reply"));
        super.addValue(253, new Value("RFC3692-style Experiment 1", "RFC3692-style Experiment 1"));
        super.addValue(254, new Value("RFC3692-style Experiment 2", "RFC3692-style Experiment 2"));
        super.addValue(255, new Value("Reserved", "Reserved"));
    }
}
