package tp7p2;

public class EnteroPositivoException extends Exception {

    private String message;

    public EnteroPositivoException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String toString() {
        return "ERROR ENTERO POSITIVO: " + this.message;
    }
}
