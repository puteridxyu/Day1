package lesson2.operators.exec;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter factorial:");
        int intA = scanner.nextInt();
        System.out.println(factorial(intA));
        scanner.close();
    }

    static long factorial(long n) {
        // base case: if n is 0 or 1, return 1
        if (n == 0 || n == 1) {
            return 1;
        } else {
            // recursive case: n! = n * (n-1)!
            return n * factorial(n - 1);
        }
    }
}
