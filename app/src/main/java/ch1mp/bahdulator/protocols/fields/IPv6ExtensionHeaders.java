package ch1mp.bahdulator.protocols.fields;

import ch1mp.bahdulator.protocols.ProtocolField;
import ch1mp.bahdulator.protocols.Value;

/**
 * The container for legal values of the IPv6 Extension Headers (i.e. Next Header field).
 *
 * Reference: IANA.org
 *
 * @author Samuel J. Brookes (sjb-ch1mp)
 *
 */
public class IPv6ExtensionHeaders extends ProtocolField {

    public IPv6ExtensionHeaders(){
        super("ipv6.extension_headers");

        super.addValue(0, new Value("HOPOPT", "IPv6 Hop-by-Hop Option"));
        super.addValue(43, new Value("IPv6-Route", "Routing Header for IPv6"));
        super.addValue(44, new Value("IPv6-Frag", "Fragment Header for IPv6"));
        super.addValue(50, new Value("ESP", "Encap Security Payload"));
        super.addValue(51, new Value("AH", "Authentication Header"));
        super.addValue(60, new Value("IPv6-Opts", "Destination Options for IPv6"));
        super.addValue(135, new Value("Mobility Header", "Mobility Header"));
        super.addValue(139, new Value("HIP", "Host Identity Protocol"));
        super.addValue(140, new Value("Shim6", "Shim6 Protocol"));
        super.addValue(253, new Value("Use for experimentation and testing", "Use for experimentation and testing"));
        super.addValue(254, new Value("Use for experimentation and testing", "Use for experimentation and testing"));
    }
}
