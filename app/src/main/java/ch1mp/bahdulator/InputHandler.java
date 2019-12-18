package ch1mp.bahdulator;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import ch1mp.bahdulator.converters.AscConverter;
import ch1mp.bahdulator.converters.BinConverter;
import ch1mp.bahdulator.converters.Converter;
import ch1mp.bahdulator.converters.DecConverter;
import ch1mp.bahdulator.converters.HexConverter;

/**
 * The InputHandler controls the EditText fields (e.g. switching them on and off depending
 * upon what the user is entering).
 */
class InputHandler {

    private final Context context;
    private final EditText etDec, etHex, etBin, etAsc;

    InputHandler(Context context, EditText etDec, EditText etHex, EditText etBin, EditText etAsc){
        this.context = context;
        this.etDec = etDec;
        this.etHex = etHex;
        this.etBin = etBin;
        this.etAsc = etAsc;
        setUpListeners();
    }

    private void setUpListeners(){

        etDec.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER){
                    try{
                        doConversion(new DecConverter(etDec));
                    }catch(Exception e){
                        showErrorMessage(e);
                    }
                }
                return false;
            }
        });

        etHex.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER){
                    try{
                        doConversion(new HexConverter(etHex));
                    }catch(Exception e){
                        showErrorMessage(e);
                    }
                }
                return false;
            }
        });

        etBin.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER){
                    try{
                        doConversion(new BinConverter(etBin));
                    }catch(Exception e){
                        showErrorMessage(e);
                    }
                }
                return false;
            }
        });

        etAsc.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER){
                    try{
                        doConversion(new AscConverter(etAsc));
                    }catch(Exception e){
                        showErrorMessage(e);
                    }
                }
                return false;
            }
        });

    }

    private void showErrorMessage(Exception e){
        Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
    }

    private void doConversion(Converter converter){
        converter.convertToAscii(etAsc);
        converter.convertToBinary(etBin);
        converter.convertToDecimal(etDec);
        converter.convertToHexadecimal(etHex);
    }
}
