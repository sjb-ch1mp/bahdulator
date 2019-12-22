package ch1mp.bahdulator.protocols;

/**
 * The Value class is a container for a legal value in a Protocol Field.
 * It contains an id (i.e. the short-hand name, or abbreviation) and
 * a description (usually a longer name).
 *
 * @author Samuel J. Brookes (sjb-ch1mp)
 */
public class Value {

    private String id;
    private String description;

    public Value(String id, String description){
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id.toUpperCase();
    }

    public String getDescription() {
        return description.toUpperCase();
    }
}
