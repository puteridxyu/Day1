package lesson3;

import java.util.Scanner;

public class MatrixPower {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter matrix size: ");
        int dim = scanner.nextInt();

        double[][] a = new double[dim][dim];

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                System.out.print("a" + (i + 1) + (j + 1) + ": ");
                a[i][j] = scanner.nextDouble();
            }
        }

        System.out.print("Enter n: ");
        int n = scanner.nextInt();

        double[][] b = new double[dim][dim];
        double[][] c = new double[dim][dim];

        // Initialize b with the identity matrix
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                b[i][j] = (i == j) ? 1.0 : 0.0;
            }
        }

        // Calculate A^n
        for (int k = 1; k <= n; k++) {
            multiplyMatrix(c, b, a, dim);
            copyMatrix(b, c, dim);
        }

        // Display the result
        System.out.println("Result:");
        displayMatrix(b, dim);

        scanner.close();
    }

    public static void multiplyMatrix(double[][] result, double[][] matrix1, double[][] matrix2, int dim) {
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                result[i][j] = 0;
                for (int k = 0; k < dim; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
    }

    public static void copyMatrix(double[][] destination, double[][] source, int dim) {
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                destination[i][j] = source[i][j];
            }
        }
    }

    public static void displayMatrix(double[][] matrix, int dim) {
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                System.out.printf("%.2f\t", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
