package lesson2.operators.exec;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your start term: ");
        int n = scanner.nextInt();
        scanner.close();

        System.out.println("Fibonacci sequence starting from term " + n + ":");
        printFibonacciSequence(n, 10);
    }

    static void printFibonacciSequence(int startTerm, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(fibonacci(startTerm + i) + ", ");
        }
    }

    static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        int firstTerm = 0;
        int secondTerm = 1;
        int nextTerm = 0;

        for (int i = 2; i <= n; i++) {
            nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }

        return nextTerm;
    }
}
