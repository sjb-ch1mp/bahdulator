package ch1mp.bahdulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    InputHandler inputHandler;
    ProtocolHandler protocolHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Boilerplate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }
}