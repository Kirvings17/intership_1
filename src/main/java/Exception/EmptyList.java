package Exception;

public class EmptyList extends Exception {
    public EmptyList() {
        super("Your haven't upload any data");
    }

    public EmptyList(String message) {
        super(message);
    }
}