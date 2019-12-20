package ch1mp.bahdulator.protocols.fields;

import ch1mp.bahdulator.protocols.ProtocolField;
import ch1mp.bahdulator.protocols.Value;

public class ICMPv6Types extends ProtocolField {

    public ICMPv6Types(){
        super("icmpv6.types");

        super.addValue(0, new Value("Reserved", "Reserved"));
        super.addValue(1, new Value("Destination Unreachable", "Destination Unreachable"));
        super.addValue(2, new Value("Packet Too Big", "Packet Too Big"));
        super.addValue(3, new Value("Time Exceeded", "Time Exceeded"));
        super.addValue(4, new Value("Parameter Problem", "Parameter Problem"));
        super.addValue(100, new Value("Private experimentation", "Private experimentation"));
        super.addValue(101, new Value("Private experimentation", "Private experimentation"));
        super.addValue(127, new Value("Reserved for expansion of ICMPv6 error messages", "Reserved for expansion of ICMPv6 error messages"));
        super.addValue(128, new Value("Echo Request", "Echo Request"));
        super.addValue(129, new Value("Echo Reply", "Echo Reply"));
        super.addValue(130, new Value("Multicast Listener Query", "Multicast Listener Query"));
        super.addValue(131, new Value("Multicast Listener Report", "Multicast Listener Report"));
        super.addValue(132, new Value("Multicast Listener Done", "Multicast Listener Done"));
        super.addValue(133, new Value("Router Solicitation", "Router Solicitation"));
        super.addValue(134, new Value("Router Advertisement", "Router Advertisement"));
        super.addValue(135, new Value("Neighbor Solicitation", "Neighbor Solicitation"));
        super.addValue(136, new Value("Neighbor Advertisement", "Neighbor Advertisement"));
        super.addValue(137, new Value("Redirect Message", "Redirect Message"));
        super.addValue(138, new Value("Router Renumbering", "Router Renumbering"));
        super.addValue(139, new Value("ICMP Node Information Query", "ICMP Node Information Query"));
        super.addValue(140, new Value("ICMP Node Information Response", "ICMP Node Information Response"));
        super.addValue(141, new Value("Inverse Neighbor Discovery Solicitation Message", "Inverse Neighbor Discovery Solicitation Message"));
        super.addValue(142, new Value("Inverse Neighbor Discovery Advertisement Message", "Inverse Neighbor Discovery Advertisement Message"));
        super.addValue(143, new Value("Version 2 Multicast Listener Report", "Version 2 Multicast Listener Report"));
        super.addValue(144, new Value("Home Agent Address Discovery Request Message", "Home Agent Address Discovery Request Message"));
        super.addValue(145, new Value("Home Agent Address Discovery Reply Message", "Home Agent Address Discovery Reply Message"));
        super.addValue(146, new Value("Mobile Prefix Solicitation", "Mobile Prefix Solicitation"));
        super.addValue(147, new Value("Mobile Prefix Advertisement", "Mobile Prefix Advertisement"));
        super.addValue(148, new Value("Certification Path Solicitation Message", "Certification Path Solicitation Message"));
        super.addValue(149, new Value("Certification Path Advertisement Message", "Certification Path Advertisement Message"));
        super.addValue(151, new Value("Multicast Router Advertisement", "Multicast Router Advertisement"));
        super.addValue(152, new Value("Multicast Router Solicitation", "Multicast Router Solicitation"));
        super.addValue(153, new Value("Multicast Router Termination", "Multicast Router Termination"));
        super.addValue(154, new Value("FMIPv6 Messages", "FMIPv6 Messages"));
        super.addValue(155, new Value("RPL Control Message", "RPL Control Message"));
        super.addValue(156, new Value("ILNPv6 Locator Update Message", "ILNPv6 Locator Update Message"));
        super.addValue(157, new Value("Duplicate Address Request", "Duplicate Address Request"));
        super.addValue(158, new Value("Duplicate Address Confirmation", "Duplicate Address Confirmation"));
        super.addValue(159, new Value("MPL Control Message", "MPL Control Message"));
        super.addValue(160, new Value("Extended Echo Request", "Extended Echo Request"));
        super.addValue(161, new Value("Extended Echo Reply", "Extended Echo Reply"));
        super.addValue(200, new Value("Private experimentation", "Private experimentation"));
        super.addValue(201, new Value("Private experimentation", "Private experimentation"));
    }
}
