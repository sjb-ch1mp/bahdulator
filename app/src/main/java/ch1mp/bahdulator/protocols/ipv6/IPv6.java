package ch1mp.bahdulator.protocols.ipv6;

import ch1mp.bahdulator.protocols.Protocol;

public class IPv6 extends Protocol {

    public IPv6(){
        super("DNS");
    }

    @Override
    void loadFields() {
        super.getFields().add(new IPv6ExtensionHeaders());
    }

}
