package lesson2.operators.exec.elvis;

import java.util.Scanner;

public class ElvisOperator {
    public static void main(String[] args) {
        int intA = 12;
        int intB = 14;

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter an int A number: ");
            intA = scanner.nextInt();

            System.out.print("Enter an int B number: ");
            intB = scanner.nextInt();

            scanner.close();

        } catch (Exception e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }

        int highest = (intA > intB) ? ((intA < 15) ? 15 : 20) : intB;

        System.out.println("The highest value is: " + highest);
    }
}
