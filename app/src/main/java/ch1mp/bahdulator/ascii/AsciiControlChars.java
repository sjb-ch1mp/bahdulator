package ch1mp.bahdulator.ascii;

/**
 * Reference : www.asciitable.com
 */

public enum AsciiControlChars {
    NUL(0, "NUL (NULL)"),
    SOH(1, "SOH (START OF HEADER)"),
    STX(2, "STX (START OF TEXT)"),
    ETX(3, "ETX (END OF TEXT)"),
    EOT(4, "EOT (END OF TRANSMISSION)"),
    ENQ(5, "ENQ (ENQUIRY)"),
    ACK(6, "ACK (ACKNOWLEDGE)"),
    BEL(7, "BEL (BELL)"),
    BS(8, "BS (BACKSPACE)"),
    TAB(9, "TAB (HORIZONTAL TAB)"),
    LF(10, "LF (LINE FEED)"),
    VT(11, "VT (VERTICAL TAB)"),
    FF(12, "FF (FORM FEED)"),
    CR(13, "CR (CARRIAGE RETURN)"),
    SO(14, "SO (SHIFT OUT)"),
    SI(15, "SI (SHIFT IN)"),
    DLE(16, "DLE (DATA LINK ESCAPE)"),
    DC1(17, "DC1 (DEVICE CONTROL 1)"),
    DC2(18, "DC2 (DEVICE CONTROL 2)"),
    DC3(19, "DC3 (DEVICE CONTROL 3)"),
    DC4(20, "DC4 (DEVICE CONTROL 4)"),
    NAK(21, "NAK (NEGATIVE ACKNOWLEDGE)"),
    SYN(22, "SYN (SYNCHRONOUS IDLE)"),
    ETB(23, "ETB (END OF TRANSMISSION BLOCK)"),
    CAN(24, "CAN (CANCEL)"),
    EM(25, "EM (END OF MEDIUM)"),
    SUB(26, "SUB (SUBSTITUTE)"),
    ESC(27, "ESC (ESCAPE)"),
    FS(28, "FS (FILE SEPARATOR)"),
    GS(29, "GS (GROUP SEPARATOR)"),
    RS(30, "RS (RECORD SEPARATOR)"),
    US(31, "US (UNIT SEPARATOR)"),
    SPC(32, "SPACE"),
    DEL(127, "DELETE");

    int val;
    String label;

    AsciiControlChars(int val, String label){
        this.val = val;
        this.label = label;
    }

    public String getLabel(){
        return label;
    }

    public static AsciiControlChars getControlChar(int i){
        for(AsciiControlChars a : AsciiControlChars.values()){
            if(a.val == i){
                return a;
            }
        }
        return null;
    }
}
