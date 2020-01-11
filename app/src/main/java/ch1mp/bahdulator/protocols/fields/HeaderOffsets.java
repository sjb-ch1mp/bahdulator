package ch1mp.bahdulator.protocols.fields;

import ch1mp.bahdulator.protocols.Protocol;
import ch1mp.bahdulator.protocols.ProtocolField;

public class HeaderOffsets extends ProtocolField {

    private final String ho = ".header_offsets";

    public HeaderOffsets(Protocol protocol){
        super("");

        switch(protocol){
            case DNS: setUpDNS(); break;
            case ETH: setUpETH(); break;
            case TCP: setUpTCP(); break;
            case UDP: setUpUDP(); break;
            case ICMP: setUpICMP(); break;
            case ICMPV6: setUpICMPV6(); break;
            case IPV4: setUpIPV4(); break;
            case IPV6: setUpIPv6();
        }
    }

    private void setUpDNS(){
        setName("dns" + ho);

    }

    private void setUpETH(){
        setName("eth" + ho);
    }

    private void setUpTCP(){
        setName("tcp" + ho);
    }

    private void setUpUDP(){
        setName("udp" + ho);
    }

    private void setUpICMP(){
        setName("icmp" + ho);
    }

    private void setUpICMPV6(){
        setName("icmpv6" + ho);
    }

    private void setUpIPV4(){
        setName("ipv4" + ho);
    }

    private void setUpIPv6(){
        setName("ipv6" + ho);
    }
}
