package tp7p2;

public class NoEncontradoException extends Exception {

    private String message;

    public NoEncontradoException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String toString() {
        return "ERROR NO ENCONTRADO: " + this.message;
    }
}