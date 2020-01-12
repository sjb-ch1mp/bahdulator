package ch1mp.bahdulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import ch1mp.bahdulator.converters.DecConverter;

/**
 * The MainActivity of Bahdulator.
 *
 * @author Samuel J. Brookes (sjb-ch1mp)
 */
public class MainActivity extends AppCompatActivity {

    InputHandler inputHandler;
    ProtocolHandler protocolHandler;
    int activeValue;
    String activeProtocol;
    ImageView btnUp;
    ImageView btnDown;
    ImageView btnInc;
    ImageView btnDec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Boilerplate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set up AboutFragment
        ImageView logo = findViewById(R.id.logo);
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AboutFragment af = new AboutFragment();
                af.show(getSupportFragmentManager(), "AboutFragment");
            }
        });

        //Set up InputHandler
        inputHandler = new InputHandler(
                this,
                (EditText) findViewById(R.id.editText_dec),
                (EditText) findViewById(R.id.editText_hex),
                (EditText) findViewById(R.id.editText_bin),
                (EditText) findViewById(R.id.editText_asc)
        );

        //Set up ProtocolHandler
        protocolHandler = new ProtocolHandler(
                this,
                (TextView) findViewById(R.id.textView_pro),
                (EditText) findViewById(R.id.editText_pro)
        );

        setUpButtons();

        activeValue = 0;
        activeProtocol = getString(R.string.arp_header_offsets);

        try{inputHandler.doConversion(new DecConverter(String.valueOf(activeValue)));}
        catch(Exception e){ /*do nothing*/}
    }

    private void setUpButtons(){

        btnUp = findViewById(R.id.btn_up);
        btnDown = findViewById(R.id.btn_down);
        btnInc = findViewById(R.id.btn_increment);
        btnDec = findViewById(R.id.btn_decrement);

        btnInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(activeValue == Integer.MAX_VALUE){
                    showToast("Already at maximum value");
                }else{
                    try{
                        inputHandler.doConversion(new DecConverter(String.valueOf(activeValue + 1)));
                    }catch(Exception e){
                        showToast(e.toString());
                    }
                }
            }
        });

        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(activeValue <= 0){
                    showToast("Already at minimum value");
                }else{
                    try{
                        inputHandler.doConversion(new DecConverter(String.valueOf(activeValue - 1)));
                    }catch(Exception e){
                        showToast(e.toString());
                    }
                }
            }
        });

        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    protocolHandler.searchForNextValue(activeProtocol, activeValue, true);
                }catch(Exception e){
                    showToast(e.toString());
                }
            }
        });

        btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    protocolHandler.searchForNextValue(activeProtocol, activeValue, false);
                }catch(Exception e){
                    showToast(e.toString());
                }
            }
        });
    }

    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    /*
     *  SETTERS
     */
    public void setActiveValue(int activeValue){
        this.activeValue = activeValue;
    }
    public void setActiveProtocol(String activeProtocol){
        this.activeProtocol = activeProtocol;
    }


    /*
    *   GETTERS
    * */
    public int getActiveValue(){
        return activeValue;
    }
    public String getActiveProtocol(){
        return activeProtocol;
    }
    public ProtocolHandler getProtocolHandler(){
        return protocolHandler;
    }
    public InputHandler getInputHandler(){
        return inputHandler;
    }
}