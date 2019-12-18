package ch1mp.bahdulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    InputHandler inputHandler;

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
    }
}