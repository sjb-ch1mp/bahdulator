package ch1mp.bahdulator.protocols.dns;

import ch1mp.bahdulator.protocols.Protocol;

public class DNS extends Protocol {

    public DNS(){

        super("DNS");

        super.addField(new DNSOpCodes());
        super.addField(new DNSRCodes());
        super.addField(new DNSRRTypes());
    }
}
