
package tp7p2;

public class CollectionVaciaException extends Exception {

    private String message;

    public CollectionVaciaException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String toString() {
        return "ERROR COLECCION VACIA: " + this.message;
    }
}
