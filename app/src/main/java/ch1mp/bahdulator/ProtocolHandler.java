package ch1mp.bahdulator;

import android.content.Context;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.ArrayList;

import ch1mp.bahdulator.protocols.Protocol;
import ch1mp.bahdulator.protocols.eth.*;
import ch1mp.bahdulator.protocols.icmp.*;
import ch1mp.bahdulator.protocols.icmpv6.*;
import ch1mp.bahdulator.protocols.ipv4.*;
import ch1mp.bahdulator.protocols.ipv6.*;
import ch1mp.bahdulator.protocols.dns.*;

class ProtocolHandler {

    private ArrayList<Protocol> protocols;
    private Context context;
    private EditText display;
    private TextView menuAnchor;
    private PopupMenu protocolMenu;

    ProtocolHandler(Context context, TextView menuAnchor, EditText display){
        loadProtocols();
        this.context = context;
        this.display = display;
        this.menuAnchor = menuAnchor;
        protocolMenu = new PopupMenu(context, menuAnchor);
    }

    void loadProtocols(){
        protocols = new ArrayList<>(0);
        protocols.add(new DNS());
        protocols.add(new Ethernet());
        protocols.add(new ICMP());
        protocols.add(new ICMPv6());
        protocols.add(new IPv4());
        protocols.add(new IPv6());
    }

    void loadMatchingFieldValues(int value){
        //clear the popup menu and then
        //load all matching field values into the popup menu
    }
}
