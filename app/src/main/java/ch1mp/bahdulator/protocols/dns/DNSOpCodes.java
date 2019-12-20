package ch1mp.bahdulator.protocols.dns;

import ch1mp.bahdulator.protocols.Field;

class DNSOpCodes extends Field {

    DNSOpCodes(){

        super("OpCodes");

        super.addValue(0,"Query");
        super.addValue(1,"Inverse Query (OBSOLETE)");
        super.addValue(2,"Status");
        super.addValue(4, "Notify");
        super.addValue(5,"Update");
        super.addValue(6,"DNS Stateful Operations");

    }
}
