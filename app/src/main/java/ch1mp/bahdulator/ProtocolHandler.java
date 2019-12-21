package ch1mp.bahdulator;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.ArrayList;

import ch1mp.bahdulator.protocols.ProtocolField;
import ch1mp.bahdulator.protocols.Value;
import ch1mp.bahdulator.protocols.fields.*;


class ProtocolHandler {

    private ArrayList<ProtocolField> protocolFields;
    private Context context;
    private EditText display;
    private TextView menuAnchor;
    private PopupMenu protocolMenu;

    ProtocolHandler(Context context, TextView menuAnchor, EditText display){
        loadProtocolFields();
        this.context = context;
        this.display = display;
        this.menuAnchor = menuAnchor;
        setUpMenu();
    }

    private void setUpMenu(){

        menuAnchor.setText(R.string.dns_opcodes);

        protocolMenu = new PopupMenu(context, menuAnchor);
        protocolMenu.getMenuInflater().inflate(R.menu.protocol_menu, protocolMenu.getMenu());
        protocolMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                ((MainActivity) context).setActiveProtocol(item.getTitle().toString());
                menuAnchor.setText(item.getTitle().toString());

                if(((MainActivity) context).getActiveValue() == -1){
                    display.setText(R.string.nothing_entered);
                }else{
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

    private void loadProtocolFields(){
        protocolFields = new ArrayList<>(0);
        protocolFields.add(new DNSOpCodes());
        protocolFields.add(new DNSRCodes());
        protocolFields.add(new DNSRRTypes());
        protocolFields.add(new EtherTypes());
        protocolFields.add(new ICMPTypes());
        protocolFields.add(new ICMPv6Types());
        protocolFields.add(new IPv4Options());
        protocolFields.add(new IPv4Protocols());
        protocolFields.add(new IPv6ExtensionHeaders());
        protocolFields.add(new TCPWellKnownPorts());
        protocolFields.add(new UDPWellKnownPorts());
    }

    private ProtocolField getProtocolField(String name){
        for(ProtocolField pf : protocolFields){
            if(pf.getName().equals(name)){
                return pf;
            }
        }
        return null;
    }

    public void clearFields(){
        if(!display.getText().toString().equals(context.getString(R.string.nothing_entered))){
            display.setText("");
        }
    }
}
