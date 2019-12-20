package ch1mp.bahdulator.protocols.ipv4;

import ch1mp.bahdulator.protocols.Protocol;

public class IPv4 extends Protocol {

    public IPv4(){
        super("DNS");
    }

    @Override
    void loadFields() {
        super.getFields().add(new IPv4Options());
        super.getFields().add(new IPv4Protocols());
    }

}
