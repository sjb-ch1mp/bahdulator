package ch1mp.bahdulator.protocols.fields;

import ch1mp.bahdulator.protocols.ProtocolField;
import ch1mp.bahdulator.protocols.Value;

public class DNSRCodes extends ProtocolField {

    public DNSRCodes(){
        super("dns.rcodes");

        super.addValue(0, new Value("NoError", "No Error"));
        super.addValue(1, new Value("FormErr", "Format Error"));
        super.addValue(2, new Value("ServFail", "Server Failure"));
        super.addValue(3, new Value("NXDomain", "Non-Existent Domain"));
        super.addValue(4, new Value("NotImp", "Not Implemented"));
        super.addValue(5, new Value("Refused", "Query Refused"));
        super.addValue(6, new Value("YXDomain", "Name Exists when it should not"));
        super.addValue(7, new Value("YXRRSet", "RR Set Exists when it should not"));
        super.addValue(8, new Value("NXRRSet", "RR Set that should exist does not"));
        super.addValue(9, new Value("NotAuth", "Server Not Authoritative for zone"));
        super.addValue(9, new Value("NotAuth", "Not Authorized"));
        super.addValue(10, new Value("NotZone", "Name not contained in zone"));
        super.addValue(11, new Value("DSOTYPENI", "DSO-TYPE Not Implemented"));
        super.addValue(16, new Value("BADVERS", "Bad OPT Version"));
        super.addValue(16, new Value("BADSIG", "TSIG Signature Failure"));
        super.addValue(17, new Value("BADKEY", "Key not recognized"));
        super.addValue(18, new Value("BADTIME", "Signature out of time window"));
        super.addValue(19, new Value("BADMODE", "Bad TKEY Mode"));
        super.addValue(20, new Value("BADNAME", "Duplicate key name"));
        super.addValue(21, new Value("BADALG", "Algorithm not supported"));
        super.addValue(22, new Value("BADTRUNC", "Bad Truncation"));
        super.addValue(23, new Value("BADCOOKIE", "Bad/missing Server Cookie"));
    }
}
