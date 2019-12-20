package ch1mp.bahdulator;

import android.content.Context;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.io.File;
import java.util.HashMap;

import ch1mp.bahdulator.protocols.Protocol;

class ProtocolHandler {

    private final String FILE_PATH = "protocols/data/";
    private HashMap<String, Protocol> protocols;
    private Context context;
    private EditText display;
    private TextView menuAnchor;
    private PopupMenu protocolMenu;

    ProtocolHandler(Context context, TextView menuAnchor, EditText display){
        loadProtocolData();
        this.context = context;
        this.display = display;
        this.menuAnchor = menuAnchor;
        protocolMenu = new PopupMenu(context, menuAnchor);
    }

    private void loadProtocolData(){
        protocols = new HashMap<>(0);
        File data = new File(FILE_PATH);
        File[] dataFiles = data.listFiles();
        if(dataFiles != null){
            for(File f : dataFiles){
                protocols.put(f.getName(), new Protocol(f.getName()));
            }
        }
    }
}
