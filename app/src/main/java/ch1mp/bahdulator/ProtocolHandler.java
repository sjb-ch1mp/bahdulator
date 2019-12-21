package ch1mp.bahdulator;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;

import ch1mp.bahdulator.protocols.ProtocolField;
import ch1mp.bahdulator.protocols.Value;
import ch1mp.bahdulator.protocols.fields.*;

/**
 * The ProtocolHandler controls the behaviour of the Protocol PopupMenu and the EditText that
 * displays search results. To save the memory load required by the app, the ProtocolHandler only
 * creates the necessary ProtocolField when the doProtocolSearch() method is called.
 *
 * @author Samuel J. Brookes (sjb-ch1mp)
 */
class ProtocolHandler {

    private Context context;
    private EditText display;
    private TextView menuAnchor;
    private PopupMenu protocolMenu;

    ProtocolHandler(Context context, TextView menuAnchor, EditText display){
        this.context = context;
        this.display = display;
        this.menuAnchor = menuAnchor;
        setUpMenu();
    }

    /**
     * Set up the PopupMenu that displays the available protocol fields that
     * can be searched, and which sets the active protocol field that will be searched.
     */
    private void setUpMenu(){

        menuAnchor.setText(R.string.dns_opcodes);

        protocolMenu = new PopupMenu(context, menuAnchor);
        protocolMenu.getMenuInflater().inflate(R.menu.protocol_menu, protocolMenu.getMenu());
        protocolMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                ((MainActivity) context).setActiveProtocol(item.getTitle().toString());
                menuAnchor.setText(item.getTitle().toString());

                if(((MainActivity) context).getActiveValue() > -1){
                    doProtocolSearch(((MainActivity) context).getActiveProtocol());
                }
                return false;
            }
        });
        menuAnchor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                protocolMenu.show();
            }
        });
    }

    /**
     * Creates the appropriate ProtocolField object and searches it for the active value.
     * If it is found, it displays the results in the display EditText field. If not, it
     * displays the phrase "Nothing found".
     *
     * @param activeProtocol - the name of the active protocol (i.e. the one showing on the
     *                       GUI)
     */
    public void doProtocolSearch(String activeProtocol){

        ProtocolField pf = getProtocolField(activeProtocol);
        if(pf != null){
            Value value = pf.getFieldValue(((MainActivity) context).getActiveValue());
            if(value != null) {
                if (!value.getId().equals(value.getDescription())){
                    if(value.getId().equals("")){
                        display.setText(value.getDescription());
                    }else if(value.getDescription().equals("")){
                        display.setText(value.getId());
                    }else{
                        display.setText(value.getId() + ": " + value.getDescription());
                    }
                }
                else{
                    display.setText(value.getId());
                }
            }
            else display.setText(R.string.nothing_found);
        }
    }

    /**
     * Creates a ProtocolField object that contains all the legal values
     * for a given protocolField.
     *
     * @param name - the name of the protocol field (e.g. dns.opcodes)
     * @return - The requested ProtocolField object
     */
    private ProtocolField getProtocolField(String name){

        if(name.equals(context.getString(R.string.dns_opcodes))){
            return new DNSOpCodes();
        }else if(name.equals(context.getString(R.string.dns_rcodes))){
            return new DNSRCodes();
        }else if(name.equals(context.getString(R.string.dns_rrtypes))){
            return new DNSRRTypes();
        }else if(name.equals(context.getString(R.string.eth_types))){
            return new EtherTypes();
        }else if(name.equals(context.getString(R.string.icmp_types))){
            return new ICMPTypes();
        }else if(name.equals(context.getString(R.string.icmpv6_types))){
            return new ICMPv6Types();
        }else if(name.equals(context.getString(R.string.ipv4_options))){
            return new IPv4Options();
        }else if(name.equals(context.getString(R.string.ipv4_protocols))){
            return new IPv4Protocols();
        }else if(name.equals(context.getString(R.string.ipv6_extension_headers))){
            return new IPv6ExtensionHeaders();
        }else if(name.equals(context.getString(R.string.tcp_well_known_ports))){
            return new TCPWellKnownPorts();
        }else if(name.equals(context.getString(R.string.udp_well_known_ports))){
            return new UDPWellKnownPorts();
        }else return null;
    }

    /**
     * Clears the display field.
     */
    public void clearFields(){
        if(!display.getText().toString().equals(context.getString(R.string.nothing_entered))){
            display.setText("");
        }
    }
}
