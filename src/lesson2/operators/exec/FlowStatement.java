package lesson2.operators.exec;

import java.util.Scanner;

public class FlowStatement {
    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        int c = 0;
        int m = 0;

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter an int A number: ");
            a = scanner.nextInt();

            System.out.print("Enter an int B number: ");
            b = scanner.nextInt();

            System.out.print("Enter an int C number: ");
            c = scanner.nextInt();

            scanner.close();

        } catch (Exception e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }

        if (a <= b) {
            m = a;
        } else {
            m = b;
        }

        if (m <= c) {
            m = c;
        }

        System.out.println("The value of m is: " + m);
    }

}
