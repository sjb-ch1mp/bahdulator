package ch1mp.bahdulator.protocols;

class FieldValue {
    private int key;
    private String keyWord;
    private String description;

    FieldValue(int key, String keyWord, String description){
        this.key = key;
        this.keyWord = keyWord;
        this.description = description;
    }

    int getKey(){ return key; }
    String getKeyWord(){ return keyWord; }
    String getDescription(){ return description; }
}
