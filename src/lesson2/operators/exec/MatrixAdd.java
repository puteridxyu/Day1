package lesson2.operators.exec;

import java.util.Scanner;

public class MatrixAdd {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your last value to sum: ");
        long n = scanner.nextInt();

        long start1 = System.currentTimeMillis();
        long matrixResult = matrix(n);
        long end1 = System.currentTimeMillis();

        System.out.println("Matrix method result: " + matrixResult);
        System.out.println("Verify method result: " + verify(n));

        float secMatrix = (end1 - start1) / 1000F;

        long end2 = System.currentTimeMillis();
        float secLoop = (end2 - end1) / 1000F;

        System.out.println("Second Matrix: " + secMatrix + ", Second Loop: " + secLoop);
        scanner.close();
    }

    static long verify(long n) {
        long sum = 0;
        for (long i = 0; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    static long matrix(long n) {
        return (n / 2) * (n + 1);
    }
}
