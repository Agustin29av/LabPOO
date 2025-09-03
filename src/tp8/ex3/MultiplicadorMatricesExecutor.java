package tp8.ex3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiplicadorMatricesExecutor {

    public static int[][] multiplicar(int[][] A, int[][] B) throws InterruptedException {
        validarDimensiones(A, B);

        int m = A.length;      // filas de A
        int p = B[0].length;   // columnas de B
        int[][] C = new int[m][p];

        int nHilos = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(nHilos);

        // Enviar una tarea por celda (igual que en Ej. 2, pero usando el pool)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                executor.submit(new TareaMultiplicacion(A, B, C, i, j));
            }
        }

        // Apagado ordenado: no aceptar más tareas y esperar a que terminen
        executor.shutdown();
        // Esperar con timeout razonable; si no alcanza, podés subirlo
        if (!executor.awaitTermination(2, TimeUnit.MINUTES)) {
            executor.shutdownNow();
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                throw new RuntimeException("El pool no terminó a tiempo.");
            }
        }

        return C;
    }

    private static void validarDimensiones(int[][] A, int[][] B) {
        if (A.length == 0 || B.length == 0) throw new IllegalArgumentException("Matrices vacías");
        int aCols = A[0].length;
        for (int[] fila : A) if (fila.length != aCols) throw new IllegalArgumentException("Matriz A no rectangular");
        int bCols = B[0].length;
        for (int[] fila : B) if (fila.length != bCols) throw new IllegalArgumentException("Matriz B no rectangular");
        if (aCols != B.length) throw new IllegalArgumentException("Incompatibles: columnas de A != filas de B");
    }
}
