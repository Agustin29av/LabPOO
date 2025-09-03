package tp8.ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiplicadorMatrices {

    public static void main(String[] args) {
        // 1) Defino A y B (ejemplo chico para ver a ojo el resultado)
        int[][] A = { {1, 2, 3}, {4, 5, 6} };       // 2x3
        int[][] B = { {7, 8}, {9, 10}, {11, 12} };  // 3x2

        // 2) Valido dimensiones (columnas A == filas B)
        validarDimensiones(A, B);

        // 3) Creo C con el tamaño correcto (m x p)
        int m = A.length;        // filas de A
        int p = B[0].length;     // columnas de B
        int[][] C = new int[m][p];

        // 4) Armo la lista de hilos
        List<Thread> hilos = new ArrayList<>(m * p);

        // 5) Recorro cada celda de C y lanzo un hilo por celda
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                Runnable tarea = new TareaMultiplicacion(A, B, C, i, j);
                Thread hilo = new Thread(tarea);
                hilos.add(hilo);
                hilo.start(); // ¡a laburar!
            }
        }

        // 6) Sincronización: espero a que todos terminen
        for (Thread hilo : hilos) {
            try {
                hilo.join(); // el main espera a cada hilo
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Main interrumpido mientras esperaba los hilos.");
                return;
            }
        }

        // 7) Finalización: ahora sí, todos los cálculos están hechos
        System.out.println("Resultado C:");
        imprimir(C);

        // Para este ejemplo concreto, lo esperable es:
        // [58, 64]
        // [139, 154]
    }

    private static void validarDimensiones(int[][] A, int[][] B) {
        if (A.length == 0 || B.length == 0) throw new IllegalArgumentException("Matrices vacías");
        int aCols = A[0].length;
        for (int[] fila : A)
            if (fila.length != aCols) throw new IllegalArgumentException("Matriz A no rectangular");
        int bCols = B[0].length;
        for (int[] fila : B)
            if (fila.length != bCols) throw new IllegalArgumentException("Matriz B no rectangular");
        if (aCols != B.length)
            throw new IllegalArgumentException("Incompatibles: columnas de A deben igualar filas de B");
    }

    private static void imprimir(int[][] M) {
        for (int[] fila : M) System.out.println(Arrays.toString(fila));
    }
}
