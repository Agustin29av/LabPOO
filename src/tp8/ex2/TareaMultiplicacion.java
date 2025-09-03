package tp8.ex2;

public class TareaMultiplicacion implements Runnable {
    private final int[][] A, B, C;
    private final int fila, columna;

    public TareaMultiplicacion(int[][] A, int[][] B, int[][] C, int fila, int columna) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.fila = fila;
        this.columna = columna;
    }

    @Override
    public void run() {
        // columnas de A == filas de B (se valida en el main antes)
        int n = A[0].length;
        int suma = 0;
        for (int k = 0; k < n; k++) {
            suma += A[fila][k] * B[k][columna];
        }
        // Cada hilo escribe una única celda distinta: no hay choques entre hilos.
        C[fila][columna] = suma;
    }
}
