package ch1mp.bahdulator;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;

import ch1mp.bahdulator.converters.DecConverter;
import ch1mp.bahdulator.protocols.Protocol;
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
                ((MainActivity) context).getInputHandler().hideSoftInput();
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
                displayProtocolDetails(value);
            }
            else display.setText(R.string.nothing_found);
        }
    }

    public void searchForNextValue(String activeProtocol, int activeValue, boolean up) throws NothingFoundException {

        ProtocolField pf = getProtocolField(activeProtocol);
        Value value = null;
        boolean altered = false;

        //reset activeValue to within the bounds of the active protocol's values
        if(!up && activeValue > pf.getMax()){
            activeValue = pf.getMax() + 1;
            altered = true;
        }
        else if(up && activeValue < pf.getMin()){
            activeValue = pf.getMin() - 1;
            altered = true;
        }

        //search for the next value
        while(altered || (activeValue >= pf.getMin() && activeValue <= pf.getMax())){

            if(altered) altered = false;

            if(up) activeValue++;
            else activeValue--;

            if((value = pf.getFieldValue(activeValue)) != null) break;
        }

        //if something was found
        if(value != null){

            ((MainActivity) context).setActiveValue(activeValue);

            try{
                ((MainActivity) context).getInputHandler().doConversion(new DecConverter(String.valueOf(activeValue)));
            }catch(Exception e){
                ((MainActivity) context).getInputHandler().showErrorMessage(e);
            }

        } else {
            //revert the last change
            if(up)activeValue--;
            else activeValue++;

            //throw an exception
            throw new NothingFoundException(pf.getName() + " has no legal values " + ((up)?"above " + pf.getMax():"below " + pf.getMin()));
        }
    }

    private void displayProtocolDetails(Value value){
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
        }else if(name.equals(context.getString(R.string.dns_header_offsets))){
            return new HeaderOffsets(Protocol.DNS);
        }else if(name.equals(context.getString(R.string.eth_types))){
            return new EtherTypes();
        }else if(name.equals(context.getString(R.string.eth_header_offsets))){
            return new HeaderOffsets(Protocol.ETH);
        }else if(name.equals(context.getString(R.string.icmp_types))){
            return new ICMPTypes();
        }else if(name.equals(context.getString(R.string.icmp_header_offsets))){
            return new HeaderOffsets(Protocol.ICMP);
        }else if(name.equals(context.getString(R.string.icmpv6_types))){
            return new ICMPv6Types();
        }else if(name.equals(context.getString(R.string.icmpv6_header_offsets))){
            return new HeaderOffsets(Protocol.ICMPV6);
        }else if(name.equals(context.getString(R.string.ipv4_options))){
            return new IPv4Options();
        }else if(name.equals(context.getString(R.string.ipv4_protocols))){
            return new IPv4Protocols();
        }else if(name.equals(context.getString(R.string.ipv4_header_offsets))){
            return new HeaderOffsets(Protocol.IPV4);
        }else if(name.equals(context.getString(R.string.ipv6_extension_headers))){
            return new IPv6ExtensionHeaders();
        }else if(name.equals(context.getString(R.string.ipv6_header_offsets))){
            return new HeaderOffsets(Protocol.IPV6);
        }else if(name.equals(context.getString(R.string.tcp_system_ports))){
            return new TCPSystemPorts();
        }else if(name.equals(context.getString(R.string.tcp_header_offsets))){
            return new HeaderOffsets(Protocol.TCP);
        }else if(name.equals(context.getString(R.string.udp_system_ports))){
            return new UDPSystemPorts();
        }else if(name.equals(context.getString(R.string.udp_header_offsets))){
            return new HeaderOffsets(Protocol.UDP);
        }

        return null;
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
