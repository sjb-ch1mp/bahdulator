package ch1mp.bahdulator.protocols.eth;

import ch1mp.bahdulator.protocols.Protocol;

public class Ethernet extends Protocol {

    public Ethernet(){
        super("Ethernet");
    }

    @Override
    void loadProtocolFields() {
        super.getFields().add(new EthernetTypes());
    }

}
