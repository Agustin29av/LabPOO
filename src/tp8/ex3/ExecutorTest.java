package tp8.ex3;

import java.util.Arrays;

public class ExecutorTest {

    private static void imprimir(int[][] M) {
        for (int[] fila : M) System.out.println(Arrays.toString(fila));
    }

    public static void main(String[] args) throws InterruptedException {
        int[][] A = { {1, 2, 3}, {4, 5, 6} };       // 2x3
        int[][] B = { {7, 8}, {9, 10}, {11, 12} };  // 3x2

        int[][] C = MultiplicadorMatricesExecutor.multiplicar(A, B);

        System.out.println("Resultado C (ExecutorService):");
        imprimir(C);
        // Esperado:
        // [58, 64]
        // [139, 154]
    }
}
