package tp7p2;

public class StringException extends Exception {

    private String message;

    public StringException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String toString() {
        return "ERROR STRING: " + this.message;
    }
}