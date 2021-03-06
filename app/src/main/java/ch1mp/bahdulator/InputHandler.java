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
 * The InputHandler controls the behaviour of the fields on the GUI of Bahdulator.
 * It takes a reference to each of the editable EditTexts in the GUI and adds OnKey- and
 * OnTouch- Listeners.
 *
 *
 * @author Samuel J. Brookes (sjb-ch1mp)
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

    /**
     * Attaches an OnKeyListener to each of the EditTexts on the GUI that listens
     * for an ENTER key press. Once the key ENTER has been pressed, the value from the field
     * is sent to the appropriate Converter and converted into the three other data types.
     */
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

    /**
     * Attaches an OnTouchListener to each of the EditTexts on the GUI. This ensures that
     * when the user touches a field to edit it, all of the fields on the screen are cleared.
     */
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

    /**
     * Takes an exception that is caught by the InputHandler and shows it in a Toast.
     * If a different exception is thrown - this method assumes that it is because the value
     * entered is too large.
     *
     * @param e - Exception
     */
    public void showErrorMessage(Exception e){
        clearFields();
        clearFocus();
        ((MainActivity) context).setActiveValue(-1);
        if(e instanceof InvalidInputException){
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Value is too large", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Takes the converter created when the ENTER key is pressed, and sets the text of
     * all EditText fields with the appropriate conversion. It then sets the active value
     * to the value showing in the DEC editText box and searches for the value in the currently
     * active protocol field.
     *
     * @param converter - Converter
     */
    public void doConversion(Converter converter){

        etAsc.setText(converter.convertToAscii());
        etBin.setText(converter.convertToBinary());
        etDec.setText(converter.convertToDecimal());
        etHex.setText(converter.convertToHexadecimal());

        ((MainActivity) context).setActiveValue(Integer.parseInt(converter.convertToDecimal()));
        ((MainActivity) context).getProtocolHandler().doProtocolSearch(((MainActivity) context).getActiveProtocol());

        clearFocus();
    }

    /**
     * Clears the focus from all boxes.
     */
    private void clearFocus(){

        etHex.clearFocus();
        etAsc.clearFocus();
        etDec.clearFocus();
        etBin.clearFocus();
        hideSoftInput();

    }

    /**
     * Hides the keyboard if it is showing
     */
    public void hideSoftInput(){
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if(imm != null){
            imm.hideSoftInputFromWindow(etHex.getWindowToken(), 0);
        }
    }

    /**
     * Empties the content from all text fields in the GUI and sets the active value to -1
     * to let other classes know that there is nothing showing on the GUI.
     */
    private void clearFields(){
        etHex.setText("");
        etAsc.setText("");
        etDec.setText("");
        etBin.setText("");
        ((MainActivity) context).getProtocolHandler().clearFields();
        ((MainActivity) context).setActiveValue(-1);
    }

}
