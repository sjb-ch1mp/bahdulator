package ch1mp.bahdulator.protocols.fields;

import ch1mp.bahdulator.protocols.ProtocolField;
import ch1mp.bahdulator.protocols.Value;

/**
 * The container for legal values of the IPv4 Protocol field.
 *
 * Reference: IANA.org
 *
 * @author Samuel J. Brookes (sjb-ch1mp)
 *
 */
public class IPv4Protocols extends ProtocolField {

    public IPv4Protocols(){
        super("ipv4.protocols");

        super.addValue(1, new Value("ICMP", "Internet Control Message"));
        super.addValue(2, new Value("IGMP", "Internet Group Management"));
        super.addValue(3, new Value("GGP", "Gateway-to-Gateway"));
        super.addValue(4, new Value("IPv4", "IPv4 encapsulation"));
        super.addValue(5, new Value("ST", "Stream"));
        super.addValue(6, new Value("TCP", "Transmission Control"));
        super.addValue(7, new Value("CBT", "CBT"));
        super.addValue(8, new Value("EGP", "Exterior Gateway Protocol"));
        super.addValue(9, new Value("IGP", "any private interior gateway (used by Cisco for their IGRP)"));
        super.addValue(10, new Value("BBN-RCC-MON", "BBN RCC Monitoring"));
        super.addValue(11, new Value("NVP-II", "Network Voice Protocol"));
        super.addValue(12, new Value("PUP", "PUP"));
        super.addValue(13, new Value("ARGUS (deprecated)", "ARGUS"));
        super.addValue(14, new Value("EMCON", "EMCON"));
        super.addValue(15, new Value("XNET", "Cross Net Debugger"));
        super.addValue(16, new Value("CHAOS", "Chaos"));
        super.addValue(17, new Value("UDP", "User Datagram"));
        super.addValue(18, new Value("MUX", "Multiplexing"));
        super.addValue(19, new Value("DCN-MEAS", "DCN Measurement Subsystems"));
        super.addValue(20, new Value("HMP", "Host Monitoring"));
        super.addValue(21, new Value("PRM", "Packet Radio Measurement"));
        super.addValue(22, new Value("XNS-IDP", "XEROX NS IDP"));
        super.addValue(23, new Value("TRUNK-1", "Trunk-1"));
        super.addValue(24, new Value("TRUNK-2", "Trunk-2"));
        super.addValue(25, new Value("LEAF-1", "Leaf-1"));
        super.addValue(26, new Value("LEAF-2", "Leaf-2"));
        super.addValue(27, new Value("RDP", "Reliable Data Protocol"));
        super.addValue(28, new Value("IRTP", "Internet Reliable Transaction"));
        super.addValue(29, new Value("ISO-TP4", "ISO Transport Protocol Class 4"));
        super.addValue(30, new Value("NETBLT", "Bulk Data Transfer Protocol"));
        super.addValue(31, new Value("MFE-NSP", "MFE Network Services Protocol"));
        super.addValue(32, new Value("MERIT-INP", "MERIT Internodal Protocol"));
        super.addValue(33, new Value("DCCP", "Datagram Congestion Control Protocol"));
        super.addValue(34, new Value("3PC", "Third Party Connect Protocol"));
        super.addValue(35, new Value("IDPR", "Inter-Domain Policy Routing Protocol"));
        super.addValue(36, new Value("XTP", "XTP"));
        super.addValue(37, new Value("DDP", "Datagram Delivery Protocol"));
        super.addValue(38, new Value("IDPR-CMTP", "IDPR Control Message Transport Proto"));
        super.addValue(39, new Value("TP++", "TP++ Transport Protocol"));
        super.addValue(40, new Value("IL", "IL Transport Protocol"));
        super.addValue(41, new Value("IPv6", "IPv6 encapsulation"));
        super.addValue(42, new Value("SDRP", "Source Demand Routing Protocol"));
        super.addValue(45, new Value("IDRP", "Inter-Domain Routing Protocol"));
        super.addValue(46, new Value("RSVP", "Reservation Protocol"));
        super.addValue(47, new Value("GRE", "Generic Routing Encapsulation"));
        super.addValue(48, new Value("DSR", "Dynamic Source Routing Protocol"));
        super.addValue(49, new Value("BNA", "BNA"));
        super.addValue(52, new Value("I-NLSP", "Integrated Net Layer Security  TUBA"));
        super.addValue(53, new Value("SWIPE (deprecated)", "IP with Encryption"));
        super.addValue(54, new Value("NARP", "NBMA Address Resolution Protocol"));
        super.addValue(55, new Value("MOBILE", "IP Mobility"));
        super.addValue(56, new Value("TLSP", "Transport Layer Security Protocol using Kryptonet key management"));
        super.addValue(57, new Value("SKIP", "SKIP"));
        super.addValue(58, new Value("IPv6-ICMP", "ICMP for IPv6"));
        super.addValue(59, new Value("IPv6-NoNxt", "No Next Header for IPv6"));
        super.addValue(61, new Value("any host internal protocol", "any host internal protocol"));
        super.addValue(62, new Value("CFTP", "CFTP"));
        super.addValue(63, new Value("any local network", "any local network"));
        super.addValue(64, new Value("SAT-EXPAK", "SATNET and Backroom EXPAK"));
        super.addValue(65, new Value("KRYPTOLAN", "Kryptolan"));
        super.addValue(66, new Value("RVD", "MIT Remote Virtual Disk Protocol"));
        super.addValue(67, new Value("IPPC", "Internet Pluribus Packet Core"));
        super.addValue(68, new Value("any distributed file system", "any distributed file system"));
        super.addValue(69, new Value("SAT-MON", "SATNET Monitoring"));
        super.addValue(70, new Value("VISA", "VISA Protocol"));
        super.addValue(71, new Value("IPCV", "Internet Packet Core Utility"));
        super.addValue(72, new Value("CPNX", "Computer Protocol Network Executive"));
        super.addValue(73, new Value("CPHB", "Computer Protocol Heart Beat"));
        super.addValue(74, new Value("WSN", "Wang Span Network"));
        super.addValue(75, new Value("PVP", "Packet Video Protocol"));
        super.addValue(76, new Value("BR-SAT-MON", "Backroom SATNET Monitoring"));
        super.addValue(77, new Value("SUN-ND", "SUN ND PROTOCOL-Temporary"));
        super.addValue(78, new Value("WB-MON", "WIDEBAND Monitoring"));
        super.addValue(79, new Value("WB-EXPAK", "WIDEBAND EXPAK"));
        super.addValue(80, new Value("ISO-IP", "ISO Internet Protocol"));
        super.addValue(81, new Value("VMTP", "VMTP"));
        super.addValue(82, new Value("SECURE-VMTP", "SECURE-VMTP"));
        super.addValue(83, new Value("VINES", "VINES"));
        super.addValue(84, new Value("TTP", "Transaction Transport Protocol"));
        super.addValue(84, new Value("IPTM", "Internet Protocol Traffic Manager"));
        super.addValue(85, new Value("NSFNET-IGP", "NSFNET-IGP"));
        super.addValue(86, new Value("DGP", "Dissimilar Gateway Protocol"));
        super.addValue(87, new Value("TCF", "TCF"));
        super.addValue(88, new Value("EIGRP", "EIGRP"));
        super.addValue(89, new Value("OSPFIGP", "OSPFIGP"));
        super.addValue(90, new Value("Sprite-RPC", "Sprite RPC Protocol"));
        super.addValue(91, new Value("LARP", "Locus Address Resolution Protocol"));
        super.addValue(92, new Value("MTP", "Multicast Transport Protocol"));
        super.addValue(93, new Value("AX.25", "AX.25 Frames"));
        super.addValue(94, new Value("IPIP", "IP-within-IP Encapsulation Protocol"));
        super.addValue(95, new Value("MICP (deprecated)", "Mobile Internetworking Control Pro."));
        super.addValue(96, new Value("SCC-SP", "Semaphore Communications Sec. Pro."));
        super.addValue(97, new Value("ETHERIP", "Ethernet-within-IP Encapsulation"));
        super.addValue(98, new Value("ENCAP", "Encapsulation Header"));
        super.addValue(99, new Value("any private encryption scheme", "any private encryption scheme"));
        super.addValue(100, new Value("GMTP", "GMTP"));
        super.addValue(101, new Value("IFMP", "Ipsilon Flow Management Protocol"));
        super.addValue(102, new Value("PNNI", "PNNI over IP"));
        super.addValue(103, new Value("PIM", "Protocol Independent Multicast"));
        super.addValue(104, new Value("ARIS", "ARIS"));
        super.addValue(105, new Value("SCPS", "SCPS"));
        super.addValue(106, new Value("QNX", "QNX"));
        super.addValue(107, new Value("A/N", "Active Networks"));
        super.addValue(108, new Value("IPComp", "IP Payload Compression Protocol"));
        super.addValue(109, new Value("SNP", "Sitara Networks Protocol"));
        super.addValue(110, new Value("Compaq-Peer", "Compaq Peer Protocol"));
        super.addValue(111, new Value("IPX-in-IP", "IPX in IP"));
        super.addValue(112, new Value("VRRP", "Virtual Router Redundancy Protocol"));
        super.addValue(113, new Value("PGM", "PGM Reliable Transport Protocol"));
        super.addValue(114, new Value("any 0-hop protocol", "any 0-hop protocol"));
        super.addValue(115, new Value("L2TP", "Layer Two Tunneling Protocol"));
        super.addValue(116, new Value("DDX", "D-II Data Exchange (DDX)"));
        super.addValue(117, new Value("IATP", "Interactive Agent Transfer Protocol"));
        super.addValue(118, new Value("STP", "Schedule Transfer Protocol"));
        super.addValue(119, new Value("SRP", "SpectraLink Radio Protocol"));
        super.addValue(120, new Value("UTI", "UTI"));
        super.addValue(121, new Value("SMP", "Simple Message Protocol"));
        super.addValue(122, new Value("SM (deprecated)", "Simple Multicast Protocol"));
        super.addValue(123, new Value("PTP", "Performance Transparency Protocol"));
        super.addValue(124, new Value("ISIS over IPv4", "ISIS over IPv4"));
        super.addValue(125, new Value("FIRE", "FIRE"));
        super.addValue(126, new Value("CRTP", "Combat Radio Transport Protocol"));
        super.addValue(127, new Value("CRUDP", "Combat Radio User Datagram"));
        super.addValue(128, new Value("SSCOPMCE", "SSCOPMCE"));
        super.addValue(129, new Value("IPLT", "IPLT"));
        super.addValue(130, new Value("SPS", "Secure Packet Shield"));
        super.addValue(131, new Value("PIPE", "Private IP Encapsulation within IP"));
        super.addValue(132, new Value("SCTP", "Stream Control Transmission Protocol"));
        super.addValue(133, new Value("FC", "Fibre Channel"));
        super.addValue(134, new Value("RSVP-E2E-IGNORE", "RSVP-E2E-IGNORE"));
        super.addValue(136, new Value("UDPLite", "UDPLite"));
        super.addValue(137, new Value("MPLS-in-IP", "MPLS-in-IP"));
        super.addValue(138, new Value("manet", "MANET Protocols"));
        super.addValue(141, new Value("WESP", "Wrapped Encapsulating Security Payload"));
        super.addValue(142, new Value("ROHC", "Robust Header Compression"));
        super.addValue(255, new Value("Reserved", "Reserved"));
    }
}
