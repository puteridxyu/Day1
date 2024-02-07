package lesson2.operators.exec.elvis;

import java.util.Scanner;

public class Exec2 {
    public static void main(String[] args) {
        int x = 12;
        int y = 14;

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter an int A number: ");
            x = scanner.nextInt();

            System.out.print("Enter an int B number: ");
            y = scanner.nextInt();

            scanner.close();

        } catch (Exception e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }

        if (x != y) {
            System.out.println("1");
        }

        if (x > y) {
            System.out.println("2");
        }

        // Added a check to avoid ArithmeticException
        if (y != 0 && x % y == 0) {
            System.out.println("3");
        }
    }

    /*
     * x=2, y=6 ouput=1
     * x=1, y=1 ouput=3
     * x=9, y=4 ouput= 1 2
     * x=10, y=5 ouput= 1 2 3
     */
}
