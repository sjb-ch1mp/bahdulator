package ch1mp.bahdulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

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

        activeValue = -1;
        activeProtocol = getString(R.string.dns_opcodes);
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