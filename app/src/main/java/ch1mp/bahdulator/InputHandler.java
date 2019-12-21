package ch1mp.bahdulator;

import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
        setUpOnKeyListeners();
        setUpOnTouchListeners();
    }

    private void setUpOnKeyListeners(){

        etDec.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER){
                    try{
                        if(!etDec.getText().toString().trim().equals("")){
                            doConversion(new DecConverter(etDec.getText().toString().trim()));
                        }
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
                        if(!etHex.getText().toString().trim().equals("")){
                            doConversion(new HexConverter(etHex.getText().toString().trim()));
                        }
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
                        if(!etBin.getText().toString().trim().equals("")){
                            doConversion(new BinConverter(etBin.getText().toString().trim()));
                        }
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
                        if(!etAsc.getText().toString().trim().equals("")){
                            doConversion(new AscConverter(etAsc.getText().toString().trim()));
                        }
                    }catch(Exception e){
                        showErrorMessage(e);
                    }
                }
                return false;
            }
        });

    }

    private void setUpOnTouchListeners(){


        etAsc.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                clearFields();
                return false;
            }
        });

        etBin.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                clearFields();
                return false;
            }
        });

        etHex.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                clearFields();
                return false;
            }
        });

        etDec.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                clearFields();
                return false;
            }
        });
    }

    private void showErrorMessage(Exception e){
        clearFields();
        clearFocus();
        ((MainActivity) context).setActiveValue(-1);
        Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
    }

    private void doConversion(Converter converter){
        etAsc.setText(converter.convertToAscii());
        etBin.setText(converter.convertToBinary());
        etDec.setText(converter.convertToDecimal());
        etHex.setText(converter.convertToHexadecimal());

        ((MainActivity) context).getProtocolHandler().doProtocolSearch();
        ((MainActivity) context).setActiveValue(Integer.parseInt(converter.convertToDecimal()));

        clearFocus();
    }

    private void clearFocus(){

        etHex.clearFocus();
        etAsc.clearFocus();
        etDec.clearFocus();
        etBin.clearFocus();

        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if(imm != null){
            imm.hideSoftInputFromWindow(etHex.getWindowToken(), 0);
        }
    }

    private void clearFields(){
        etHex.setText("");
        etAsc.setText("");
        etDec.setText("");
        etBin.setText("");
        ((MainActivity) context).getProtocolHandler().clearFields();
        ((MainActivity) context).setActiveValue(-1);
    }

}
