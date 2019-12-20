package ch1mp.bahdulator;

import android.content.Context;
import android.view.MenuItem;
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

    void setUpMenu(){
        protocolMenu = new PopupMenu(context, menuAnchor);
        protocolMenu.getMenuInflater().inflate(R.menu.protocol_menu, protocolMenu.getMenu());
        protocolMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                ProtocolField pf = getProtocolField(item.getTitle().toString());
                if(pf != null){
                    Value value = pf.getFieldValue(((MainActivity) context).getActiveValue());
                    if(value != null){
                        if(value.getId() != value.getDescription())
                            display.setText(value.getId() + ": " + value.getDescription());
                        else
                            display.setText(value.getId());
                    }
                }
                return false;
            }
        });
    }

    void loadProtocolFields(){
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
    }

    ProtocolField getProtocolField(String name){
        for(ProtocolField pf : protocolFields){
            if(pf.getName().equals(name)){
                return pf;
            }
        }
        return null;
    }
}
