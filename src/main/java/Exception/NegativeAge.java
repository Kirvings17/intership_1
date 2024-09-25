package Exception;

public class NegativeAge extends Exception {
    public NegativeAge() {
        super("There is a negative age in the file");
    }
}