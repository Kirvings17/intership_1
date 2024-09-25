package Exception;

public class NewZealandNotPresent extends Exception {
    public NewZealandNotPresent() {
        super("You can't call this command as there are no data from person from NewZealand");
    }
}