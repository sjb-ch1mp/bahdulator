package ch1mp.bahdulator.protocols.fields;

import ch1mp.bahdulator.protocols.ProtocolField;
import ch1mp.bahdulator.protocols.Value;

/**
 * The container for legal values of the DNS RR Type field.
 *
 * Reference: IANA.org
 *
 * @author Samuel J. Brookes (sjb-ch1mp)
 *
 */
public class DNSRRTypes extends ProtocolField {

    public DNSRRTypes(){
        super("dns.rr_types");

        super.addValue(1, new Value("A", "a host address"));
        super.addValue(2, new Value("NS", "an authoritative name server"));
        super.addValue(3, new Value("MD", "a mail destination (OBSOLETE - use MX)"));
        super.addValue(4, new Value("MF", "a mail forwarder (OBSOLETE - use MX)"));
        super.addValue(5, new Value("CNAME", "the canonical name for an alias"));
        super.addValue(6, new Value("SOA", "marks the start of a zone of authority"));
        super.addValue(7, new Value("MB", "a mailbox domain name (EXPERIMENTAL)"));
        super.addValue(8, new Value("MG", "a mail group member (EXPERIMENTAL)"));
        super.addValue(9, new Value("MR", "a mail rename domain name (EXPERIMENTAL)"));
        super.addValue(10, new Value("NULL", "a null RR (EXPERIMENTAL)"));
        super.addValue(11, new Value("WKS", "a well known service description"));
        super.addValue(12, new Value("PTR", "a domain name pointer"));
        super.addValue(13, new Value("HINFO", "host information"));
        super.addValue(14, new Value("MINFO", "mailbox or mail list information"));
        super.addValue(15, new Value("MX", "mail exchange"));
        super.addValue(16, new Value("TXT", "text strings"));
        super.addValue(17, new Value("RP", "for Responsible Person"));
        super.addValue(18, new Value("AFSDB", "for AFS Data Base location"));
        super.addValue(19, new Value("X25", "for X.25 PSDN address"));
        super.addValue(20, new Value("ISDN", "for ISDN address"));
        super.addValue(21, new Value("RT", "for Route Through"));
        super.addValue(22, new Value("NSAP", "for NSAP address NSAP style A record"));
        super.addValue(23, new Value("NSAP-PTR", "for domain name pointer NSAP style"));
        super.addValue(24, new Value("SIG", "for security signature"));
        super.addValue(25, new Value("KEY", "for security key"));
        super.addValue(26, new Value("PX", "X.400 mail mapping information"));
        super.addValue(27, new Value("GPOS", "Geographical Position"));
        super.addValue(28, new Value("AAAA", "IP6 Address"));
        super.addValue(29, new Value("LOC", "Location Information"));
        super.addValue(30, new Value("NXT", "Next Domain (OBSOLETE)"));
        super.addValue(31, new Value("EID", "Endpoint Identifier"));
        super.addValue(32, new Value("NIMLOC", "Nimrod Locator"));
        super.addValue(33, new Value("SRV", "Server Selection"));
        super.addValue(34, new Value("ATMA", "ATM Address"));
        super.addValue(35, new Value("NAPTR", "Naming Authority Pointer"));
        super.addValue(36, new Value("KX", "Key Exchanger"));
        super.addValue(37, new Value("CERT", "CERT"));
        super.addValue(38, new Value("A6", "A6 (OBSOLETE - use AAAA)"));
        super.addValue(39, new Value("DNAME", "DNAME"));
        super.addValue(40, new Value("SINK", "SINK"));
        super.addValue(41, new Value("OPT", "OPT"));
        super.addValue(42, new Value("APL", "APL"));
        super.addValue(43, new Value("DS", "Delegation Signer"));
        super.addValue(44, new Value("SSHFP", "SSH Key Fingerprint"));
        super.addValue(45, new Value("IPSECKEY", "IPSECKEY"));
        super.addValue(46, new Value("RRSIG", "RRSIG"));
        super.addValue(47, new Value("NSEC", "NSEC"));
        super.addValue(48, new Value("DNSKEY", "DNSKEY"));
        super.addValue(49, new Value("DHCID", "DHCID"));
        super.addValue(50, new Value("NSEC3", "NSEC3"));
        super.addValue(51, new Value("NSEC3PARAM", "NSEC3PARAM"));
        super.addValue(52, new Value("TLSA", "TLSA"));
        super.addValue(53, new Value("SMIMEA", "S/MIME cert association"));
        super.addValue(54, new Value("Unassigned", "Unassigned"));
        super.addValue(55, new Value("HIP", "Host Identity Protocol"));
        super.addValue(56, new Value("NINFO", "NINFO"));
        super.addValue(57, new Value("RKEY", "RKEY"));
        super.addValue(58, new Value("TALINK", "Trust Anchor LINK"));
        super.addValue(59, new Value("CDS", "Child DS"));
        super.addValue(60, new Value("CDNSKEY", "DNSKEY(s) the Child wants reflected in DS"));
        super.addValue(61, new Value("OPENPGPKEY", "OpenPGP Key"));
        super.addValue(62, new Value("CSYNC", "Child-To-Parent Synchronization"));
        super.addValue(63, new Value("ZONEMD", "message digest for DNS zone"));
        super.addValue(99, new Value("SPF", "SPF"));
        super.addValue(100, new Value("UINFO", "UINFO"));
        super.addValue(101, new Value("UID", "UID"));
        super.addValue(102, new Value("GID", "GID"));
        super.addValue(103, new Value("UNSPEC", "UNSPEC"));
        super.addValue(104, new Value("NID", "NID"));
        super.addValue(105, new Value("L32", "L32"));
        super.addValue(106, new Value("L64", "L64"));
        super.addValue(107, new Value("LP", "LP"));
        super.addValue(108, new Value("EUI48", "an EUI-48 address"));
        super.addValue(109, new Value("EUI64", "an EUI-64 address"));
        super.addValue(249, new Value("TKEY", "Transaction Key"));
        super.addValue(250, new Value("TSIG", "Transaction Signature"));
        super.addValue(251, new Value("IXFR", "incremental transfer"));
        super.addValue(252, new Value("AXFR", "transfer of an entire zone"));
        super.addValue(253, new Value("MAILB", "mailbox-related RRs (MB MG or MR)"));
        super.addValue(254, new Value("MAILA", "mail agent RRs (OBSOLETE - see MX)"));
        super.addValue(255, new Value("*", "A request for some or all records the server has available"));
        super.addValue(256, new Value("URI", "URI"));
        super.addValue(257, new Value("CAA", "Certification Authority Restriction"));
        super.addValue(258, new Value("AVC", "Application Visibility and Control"));
        super.addValue(259, new Value("DOA", "Digital Object Architecture"));
        super.addValue(260, new Value("AMTRELAY", "Automatic Multicast Tunneling Relay"));
    }
}
