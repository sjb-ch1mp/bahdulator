package ch1mp.bahdulator.protocols.icmpv6;

import ch1mp.bahdulator.protocols.Protocol;

public class ICMPv6 extends Protocol {

    public ICMPv6(){
        super("DNS");
    }

    @Override
    void loadFields() {
        super.getFields().add(new ICMPv6Types());
    }
}
