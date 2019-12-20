package ch1mp.bahdulator.protocols.icmp;

import ch1mp.bahdulator.protocols.Protocol;

public class ICMP extends Protocol {

    public ICMP(){
        super("DNS");
    }

    @Override
    void loadFields() {
        super.getFields().add(new ICMPTypes());
    }
}
