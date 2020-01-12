package ch1mp.bahdulator.protocols.fields;

import ch1mp.bahdulator.protocols.Protocol;
import ch1mp.bahdulator.protocols.ProtocolField;
import ch1mp.bahdulator.protocols.Value;

public class HeaderOffsets extends ProtocolField {

    private final String ho = ".header_offsets";

    public HeaderOffsets(Protocol protocol){
        super("");

        switch(protocol){
            case ARP: setUpARP(); break;
            case DNS: setUpDNS(); break;
            case ETH: setUpETH(); break;
            case TCP: setUpTCP(); break;
            case UDP: setUpUDP(); break;
            case ICMP: setUpICMP(); break;
            case IPV4: setUpIPV4(); break;
            case IPV6: setUpIPv6();
        }
    }

    private void setUpARP(){
        setName("arp" + ho);
        addValue(0, new Value("HRD", "Hardware Type"));
        addValue(16, new Value("PRO", "Protocol Type"));
        addValue(32, new Value("HLN", "Hardware Address Length"));
        addValue(40, new Value("PLN", "Protocol Address Length"));
        addValue(48, new Value("OP", "Operation Code"));
        addValue(64, new Value("SHA", "Sender Hardware Address (for ETH & IPv4)"));
        addValue(96, new Value("SPA", "Sender Protocol Address (for ETH & IPv4)"));
        addValue(144, new Value("THA", "Target Hardware Address (for ETH & IPv4)"));
        addValue(192, new Value("TPA", "Target Protocol Address (for ETH & IPv4)"));
    }

    private void setUpDNS(){
        setName("dns" + ho);
        addValue(0, new Value("ID", "Identifier"));
        addValue(16, new Value("QR", "Query/Response Flag"));
        addValue(17, new Value("OPCODE", "Operation Code"));
        addValue(21, new Value("AA", "Authoritative Answer Flag"));
        addValue(22, new Value("TC", "Truncation Flag"));
        addValue(23, new Value("RD", "Recursion Desired Flag"));
        addValue(24, new Value("RA", "Recursion Available Flag"));
        addValue(25, new Value("Z", "Zero"));
        addValue(26, new Value("AD", "Authentic Data (DNSSEC)"));
        addValue(27, new Value("CD", "Checking Disabled (DNSSEC)"));
        addValue(28, new Value("RCODE", "Response Code"));
        addValue(32, new Value("QDCount", "Question Count"));
        addValue(48, new Value("ANCount", "Answer Count"));
        addValue(64, new Value("NSCount", "Authority Record Count"));
        addValue(80, new Value("ARCount", "Additional Record Count"));
        addValue(96, new Value("RR", "Resource Records (Variable Length)"));
    }

    private void setUpETH(){
        setName("eth" + ho);
        addValue(0, new Value("Destination MAC Address", ""));
        addValue(48, new Value("Source MAC Address", ""));
        addValue(96, new Value("Ethernet Type/VLAN tag", ""));
        addValue(112, new Value("TCI", "Tag Control Information (if VLAN)"));
        addValue(128, new Value("Ethernet Type", "(if VLAN)"));
    }

    private void setUpTCP(){
        setName("tcp" + ho);
        addValue(0, new Value("Source Port", ""));
        addValue(16, new Value("Destination Port", ""));
        addValue(32, new Value("Sequence Number", ""));
        addValue(64, new Value("Acknowledgment Number", ""));
        addValue(96, new Value("Data Offset/Header Length", ""));
        addValue(100, new Value("Reserved", ""));
        addValue(104, new Value("CWR", "Congestion Window Reduced Flag"));
        addValue(105, new Value("ECE", "Explicit Congestion Echo Flag"));
        addValue(106, new Value("URG", "Urgent Flag"));
        addValue(107, new Value("ACK", "Acknowledge Flag"));
        addValue(108, new Value("PUSH", "Push Flag"));
        addValue(109, new Value("RST", "Reset Flag"));
        addValue(110, new Value("SYN", "Synchronize Flag"));
        addValue(111, new Value("FIN", "Finish Flag"));
        addValue(112, new Value("Window Size", ""));
        addValue(128, new Value("Checksum", ""));
        addValue(144, new Value("Urgent Pointer", ""));
        addValue(160, new Value("Options", "(Variable length)"));
    }

    private void setUpUDP(){
        setName("udp" + ho);
        addValue(0, new Value("Source Port", ""));
        addValue(16, new Value("Destination Port", ""));
        addValue(32, new Value("Length", ""));
        addValue(48, new Value("Checksum", ""));
    }

    private void setUpICMP(){
        setName("icmp" + ho);
        addValue(0, new Value("Type", ""));
        addValue(8, new Value("Code", ""));
        addValue(16, new Value("Checksum", ""));
        addValue(32, new Value("Additional information", ""));
    }

    private void setUpIPV4(){
        setName("ipv4" + ho);
        addValue(0, new Value("Version", ""));
        addValue(4, new Value("IHL", "Internet Header Length"));
        addValue(8, new Value("TOS", "Type of Service/Differentiated Services"));
        addValue(14, new Value("ECN", "Explicit Congestion Notification bits"));
        addValue(16, new Value("TL", "Total Length"));
        addValue(32, new Value("ID", "Identification"));
        addValue(48, new Value("Reserved", "Zero"));
        addValue(49, new Value("DF", "Don't Fragment"));
        addValue(50, new Value("MF", "More Fragments"));
        addValue(51, new Value("Fragment Offset", ""));
        addValue(64, new Value("TTL", "Time to Live"));
        addValue(72, new Value("Protocol", ""));
        addValue(80, new Value("Header Checksum", ""));
        addValue(96, new Value("Source Address", ""));
        addValue(128, new Value("Destination Address", ""));
        addValue(160, new Value("Options", "(Variable Length)"));
    }

    private void setUpIPv6(){
        setName("ipv6" + ho);
        addValue(0, new Value("Version", ""));
        addValue(4, new Value("Traffic Class", ""));
        addValue(12, new Value("Flow Label", ""));
        addValue(32, new Value("Payload Length", ""));
        addValue(48, new Value("NH", "Next Header"));
        addValue(56, new Value("Hop Limit", ""));
        addValue(64, new Value("Source Address", ""));
        addValue(192, new Value("Destination Address", ""));
        addValue(320, new Value("EH", "Extension Headers (Variable Length)"));
    }
}
