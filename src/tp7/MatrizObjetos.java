package tp7;
import java.util.*;

public class MatrizObjetos {
    static int max_rows = 200;
    static int max_cols = 200;
    
    private Vector[] cuerpo;

    /**
     * Constructor de la matriz que implementa validaciones completas.
     * @param columnas El número de columnas de la matriz.
     * @param filas    El número de filas de la matriz.
     * @throws MatrizException Si las dimensiones son inválidas (negativas o exceden el máximo).
     */
    MatrizObjetos(int columnas, int filas) throws MatrizException {
        // Parte B, punto 1: Validación de dimensiones en el constructor.
        if (columnas <= 0 || filas <= 0) {
            throw new MatrizException(MatrizException.ERR_DIMENSIONES_NEGATIVAS);
        }
        if (columnas > max_cols) {
            throw new MatrizException(MatrizException.ERR_COLUMNAS_EXCEDIDAS);
        }
        if (filas > max_rows) {
            throw new MatrizException(MatrizException.ERR_FILAS_EXCEDIDAS);
        }
        
        // Si las validaciones pasan, se procede a inicializar la matriz.
        this.cuerpo = new Vector[filas];
        for(int i = 0; i < filas; i++) {
            this.cuerpo[i] = new Vector(columnas); // Se inicializa con la capacidad correcta
            for (int j = 0; j < columnas; j++) {
                // Se llena la matriz con valores nulos o un valor por defecto.
                // Esto asegura que GetRowCol no falle al intentar acceder a un índice vacío.
                this.cuerpo[i].add(null); 
            }
        }
    }

    /**
     * Establece un objeto en una posición específica de la matriz.
     * @param row El índice de la fila.
     * @param col El índice de la columna.
     * @param obj El objeto a insertar.
     * @throws MatrizException Si los índices están fuera de rango.
     */
    public void SetRowCol(int row, int col, Object obj) throws MatrizException {
        // Parte B, punto 2: Implementación de programación defensiva.
        // Se elimina el try-catch "tragador" y se valida antes de acceder al arreglo.
        if (row < 0 || row >= this.cuerpo.length) {
            throw new MatrizException(MatrizException.ERR_FILA_FUERA_DE_RANGO);
        }
        if (col < 0 || col >= this.cuerpo[row].size()) {
            throw new MatrizException(MatrizException.ERR_COLUMNA_FUERA_DE_RANGO);
        }
        
        // Si los índices son válidos, se realiza la operación.
        this.cuerpo[row].set(col, obj);
    }
    
    /**
     * Obtiene un objeto de una posición específica de la matriz.
     * @param row El índice de la fila.
     * @param col El índice de la columna.
     * @return El objeto en la posición (row, col).
     * @throws MatrizException Si los índices están fuera de rango.
     */
    public Object GetRowCol(int row, int col) throws MatrizException {
        // Parte B, punto 3: Se corrige el anti-patrón de try-catch-finally.
        // Se valida el rango de los índices y se lanza una excepción si son inválidos.
        if (row < 0 || row >= this.cuerpo.length) {
            throw new MatrizException(MatrizException.ERR_FILA_FUERA_DE_RANGO);
        }
        if (col < 0 || col >= this.cuerpo[row].size()) {
            throw new MatrizException(MatrizException.ERR_COLUMNA_FUERA_DE_RANGO);
        }
        
        // Si los índices son válidos, se retorna el objeto.
        return this.cuerpo[row].elementAt(col);
    }
    
    /**
     * Convierte la matriz a una cadena de texto.
     * @return La representación en String de la matriz.
     */
    @Override
    public String toString(){
        String staux = "";
        for(int i = 0; i < cuerpo.length; i++) {
            for(int j = 0; j < cuerpo[i].size(); j++){
                // Se agrega un espacio para una mejor visualización.
                staux += cuerpo[i].elementAt(j) + " ";
            }
        }
        return staux;
    }
}
