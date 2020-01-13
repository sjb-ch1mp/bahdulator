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
        addValue(2, new Value("PRO", "Protocol Type"));
        addValue(4, new Value("HLN", "Hardware Address Length"));
        addValue(5, new Value("PLN", "Protocol Address Length"));
        addValue(6, new Value("OP", "Operation Code"));
        addValue(8, new Value("SHA", "Sender Hardware Address (for ETH & IPv4)"));
        addValue(14, new Value("SPA", "Sender Protocol Address (for ETH & IPv4)"));
        addValue(18, new Value("THA", "Target Hardware Address (for ETH & IPv4)"));
        addValue(24, new Value("TPA", "Target Protocol Address (for ETH & IPv4)"));
    }

    private void setUpDNS(){
        setName("dns" + ho);
        addValue(0, new Value("ID", "Identifier"));
        addValue(2, new Value("Flags", "QR|OPCODE(4 bits)|AA|TC|RD|RA|Z|AD|CD|RCODE(4 bits)"));
        addValue(4, new Value("Query Count", ""));
        addValue(6, new Value("Answer Count", ""));
        addValue(8, new Value("Authority Record Count", ""));
        addValue(10, new Value("Additional Record Count", ""));
        addValue(12, new Value("RR", "Resource Records (Variable Length)"));
    }

    private void setUpETH(){
        setName("eth" + ho);
        addValue(0, new Value("Destination MAC Address", ""));
        addValue(6, new Value("Source MAC Address", ""));
        addValue(12, new Value("Ethernet Type/VLAN tag", ""));
        addValue(14, new Value("TCI", "Tag Control Information (if VLAN)"));
        addValue(16, new Value("Ethernet Type", "(if VLAN)"));
    }

    private void setUpTCP(){
        setName("tcp" + ho);
        addValue(0, new Value("Source Port", ""));
        addValue(2, new Value("Destination Port", ""));
        addValue(4, new Value("Sequence Number", ""));
        addValue(8, new Value("Acknowledgment Number", ""));
        addValue(12, new Value("Header Length (4 bits) & Reserved (4 bits)", ""));
        addValue(13, new Value("Flags", "CWR|ECE|URG|ACK|PSH|RST|SYN|FIN"));
        addValue(14, new Value("Window Size", ""));
        addValue(16, new Value("Checksum", ""));
        addValue(18, new Value("Urgent Pointer", ""));
        addValue(20, new Value("Options", "(Variable length)"));
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
        addValue(1, new Value("Code", ""));
        addValue(2, new Value("Checksum", ""));
        addValue(4, new Value("Additional information", ""));
    }

    private void setUpIPV4(){
        setName("ipv4" + ho);
        addValue(0, new Value("Version (4 bits) & Header Length (4 bits)", ""));
        addValue(1, new Value("TOS", "Type of Service/Differentiated Services"));
        addValue(2, new Value("TL", "Total Length"));
        addValue(4, new Value("ID", "Identification"));
        addValue(6, new Value("Flags (3 bits) & Fragmentation Offset (13 bits)", "Zero|DF|MF|Offset"));
        addValue(8, new Value("TTL", "Time to Live"));
        addValue(9, new Value("Protocol", ""));
        addValue(10, new Value("Header Checksum", ""));
        addValue(12, new Value("Source Address", ""));
        addValue(16, new Value("Destination Address", ""));
        addValue(20, new Value("Options", "(Variable Length)"));
    }

    private void setUpIPv6(){
        setName("ipv6" + ho);
        addValue(0, new Value("Version (4 bits) & Traffic Class (8 bits) & Flow Label (20 bits)", ""));
        addValue(4, new Value("Payload Length", ""));
        addValue(6, new Value("NH", "Next Header"));
        addValue(7, new Value("Hop Limit", ""));
        addValue(8, new Value("Source Address", ""));
        addValue(24, new Value("Destination Address", ""));
        addValue(40, new Value("EH", "Extension Headers (Variable Length)"));
    }
}
