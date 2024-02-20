package lesson11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class H_ParallelMatrixMultiplication {

    public static void main(String[] args) {
        int[][] matrixA = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int[][] matrixB = {
                { 9, 8, 7 },
                { 6, 5, 4 },
                { 3, 2, 1 }
        };

        int[][] result = multiplyMatrices(matrixA, matrixB);

        // Print the result matrix
        for (int[] row : result) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;

        if (colsA != rowsB) {
            throw new IllegalArgumentException("Incompatible matrix dimensions for multiplication");
        }

        int[][] result = new int[rowsA][colsB];

        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                executor.submit(new MatrixMultiplier(matrixA, matrixB, result, i, j, colsA));
            }
        }

        executor.shutdown();

        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result;
    }
}

class MatrixMultiplier implements Runnable {
    private final int[][] matrixA;
    private final int[][] matrixB;
    private final int[][] result;
    private final int row;
    private final int col;
    private final int colsA;

    public MatrixMultiplier(int[][] matrixA, int[][] matrixB, int[][] result, int row, int col, int colsA) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.result = result;
        this.row = row;
        this.col = col;
        this.colsA = colsA;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = 0; i < colsA; i++) {
            sum += matrixA[row][i] * matrixB[i][col];
        }
        result[row][col] = sum;
    }
}
