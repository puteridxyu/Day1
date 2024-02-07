package lesson2.operators.exec;

import java.util.Scanner;

public class FlowState2 {
    public static void main(String[] args) {
        int i = 1; // start from 1 for factorial calculation
        int n = 0;
        int nFact = 1; // initialize nFact to 1 for factorial calculation

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter an int i number: ");
            i = scanner.nextInt();

            System.out.print("Enter an int n number: ");
            n = scanner.nextInt();

            scanner.close();

        } catch (Exception e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }

        while (i <= n) {
            nFact = nFact * i;
            i++;
        }

        System.out.println("n! = " + nFact);
    }
}
