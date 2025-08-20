package tp7;

import java.util.*;

public class MatrizException extends Exception {

    // Parte A, punto 1: Uso de constantes para códigos de error.
    // Esto mejora la legibilidad y evita el uso de "números mágicos".
    public static final int ERR_COLUMNAS_EXCEDIDAS = 0;
    public static final int ERR_FILAS_EXCEDIDAS = 1;
    public static final int ERR_DIMENSIONES_NEGATIVAS = 2;
    public static final int ERR_FILA_FUERA_DE_RANGO = 3;
    public static final int ERR_COLUMNA_FUERA_DE_RANGO = 4;
    
    // Parte A, punto 2: Arreglo de mensajes de error con descripciones más claras.
    private static final String[] ERRORES = {
        "El número de columnas excede el máximo permitido.",
        "El número de filas excede el máximo permitido.",
        "Las dimensiones de la matriz no pueden ser negativas o cero.",
        "El índice de la fila está fuera de rango.",
        "El índice de la columna está fuera de rango."
    };
    
    private String name;

    // Constructor que recibe el nombre de la excepción. Se mantiene por compatibilidad.
    public MatrizException(String nom){
        name = nom;
    }
    
    // Constructor modificado para usar los códigos de error definidos como constantes.
    public MatrizException(int numError){
        // Valida que el código de error sea válido antes de acceder al arreglo.
        if (numError >= 0 && numError < ERRORES.length) {
            this.name = ERRORES[numError];
        } else {
            this.name = "Código de error no válido.";
        }
    }
    
    // Devuelve una representación en cadena de la excepción.
    @Override
    public String toString() {
        return "ERROR MATRIZ: " + name;
    }
}