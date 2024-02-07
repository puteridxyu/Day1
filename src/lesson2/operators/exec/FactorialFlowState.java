package lesson2.operators.exec;

import java.util.Scanner;

public class FactorialFlowState {
    public static void main(String[] args) {
        int n = 0;
        long nFact = 1; // Use long to handle larger factorial values

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter an int n number: ");
            n = scanner.nextInt();

            scanner.close();

        } catch (Exception e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }

        int i = 1; // Start i from 1 for factorial calculation
        while (i <= n) {
            nFact *= i;
            i++;
        }

        System.out.println("n! = " + nFact);
    }
}
